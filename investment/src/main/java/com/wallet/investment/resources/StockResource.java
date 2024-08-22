package com.wallet.investment.resources;

import com.wallet.investment.domain.Stock;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.service.VariableIncomeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
@CrossOrigin("*")
public class StockResource {

    private final VariableIncomeService<Stock> variableIncomeService;

    public StockResource(VariableIncomeService<Stock> variableIncomeService) {
        this.variableIncomeService = variableIncomeService;
    }

    @GetMapping
    public VariableIncomeRecord getStocks() {
        return variableIncomeService.findAll();
    }
}
