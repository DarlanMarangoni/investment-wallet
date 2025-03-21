package com.darlanmarangoni.investmentapi.resources;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import com.darlanmarangoni.investmentapi.service.VariableIncomeService;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
