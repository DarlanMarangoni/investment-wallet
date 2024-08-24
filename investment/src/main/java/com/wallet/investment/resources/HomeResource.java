package com.wallet.investment.resources;

import com.wallet.investment.domain.RealStateFund;
import com.wallet.investment.domain.Stock;
import com.wallet.investment.records.LineChartHomeDataRecord;
import com.wallet.investment.service.VariableIncomeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class HomeResource {

    private final VariableIncomeService<Stock> stockService;
    private final VariableIncomeService<RealStateFund> realStateFundService;

    public HomeResource(VariableIncomeService<Stock> stockService, VariableIncomeService<RealStateFund> realStateFundService) {
        this.stockService = stockService;
        this.realStateFundService = realStateFundService;
    }

    @GetMapping("/line-chart-data")
    public List<LineChartHomeDataRecord> getLineChartData() {
        List<LineChartHomeDataRecord> fullList = new ArrayList<>(0);
        var firstList = stockService.findAllByDay();
        var secondList = realStateFundService.findAllByDay();
        fullList.addAll(firstList);
        fullList.addAll(secondList);
        return fullList.stream()
                .collect(Collectors.groupingBy(
                        LineChartHomeDataRecord::date,
                        Collectors.mapping(
                                LineChartHomeDataRecord::total,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                )).entrySet().stream().map(m -> new LineChartHomeDataRecord(m.getValue(), m.getKey()))
                .sorted(Comparator.comparing(LineChartHomeDataRecord::date))
                .toList();
    }
}
