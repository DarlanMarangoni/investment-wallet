package com.darlanmarangoni.investmentapi.resources;

import com.darlanmarangoni.investmentapi.domain.Stock;
import com.darlanmarangoni.investmentapi.records.VariableIncomeRecord;
import com.darlanmarangoni.investmentapi.service.VariableIncomeService;
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
