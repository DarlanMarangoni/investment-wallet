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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
        List<LineChartHomeDataRecord> investments = new ArrayList<>(0);
        investments.addAll(stockService.findAllByDay());
        investments.addAll(realStateFundService.findAllByDay());
        var investmentsByDateTime = investments.stream()
                .collect(Collectors.groupingBy(
                        LineChartHomeDataRecord::date,
                        Collectors.mapping(
                                LineChartHomeDataRecord::total,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));
        var maxByDay = new HashMap<LocalDateTime, LineChartHomeDataRecord>();
        investmentsByDateTime.forEach((key, value) -> {
            if (maxByDay.get(key.toLocalDate().atStartOfDay()) == null) {
                maxByDay.put(key.toLocalDate().atStartOfDay(), new LineChartHomeDataRecord(value, key.toLocalDate().atStartOfDay()));
            } else {
                LineChartHomeDataRecord lineChartHomeDataRecord = maxByDay.get(key.toLocalDate().atStartOfDay());
                if (lineChartHomeDataRecord != null && value.compareTo(lineChartHomeDataRecord.total()) > 0) {
                    maxByDay.put(key.toLocalDate().atStartOfDay(), new LineChartHomeDataRecord(value, key.toLocalDate().atStartOfDay()));
                }
            }
        });
        return maxByDay.entrySet().stream()
                .map(m -> new LineChartHomeDataRecord(m.getValue().total(), m.getKey()))
                .sorted(Comparator.comparing(LineChartHomeDataRecord::date))
                .toList();
    }
}
