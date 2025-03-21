package com.darlanmarangoni.investmentapi.resources;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import com.darlanmarangoni.investmentapi.service.VariableIncomeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/real-state-fund")
@CrossOrigin("*")
public class RealStateFundResource {

    private final VariableIncomeService<RealStateFund> variableIncomeService;

    public RealStateFundResource(VariableIncomeService<RealStateFund> variableIncomeService) {
        this.variableIncomeService = variableIncomeService;
    }

    @GetMapping
    public Page<RealStateFund> getStocks(Pageable pageable) {
        return variableIncomeService.findLastCote(pageable);
    }

}
