package com.darlanmarangoni.investmentapi.resources;

import com.darlanmarangoni.investmentapi.domain.Stock;
import com.darlanmarangoni.investmentapi.service.VariableIncomeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockResource {

    private final VariableIncomeService<Stock> variableIncomeService;

    public StockResource(VariableIncomeService<Stock> variableIncomeService) {
        this.variableIncomeService = variableIncomeService;
    }

    @GetMapping
    public Page<Stock> getStocks(Pageable pageable) {
        return variableIncomeService.findLastCote(pageable);
    }

}
