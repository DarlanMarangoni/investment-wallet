package com.wallet.investment.resources;

import com.wallet.investment.domain.RealStateFund;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.service.VariableIncomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/real-state-fund")
public class RealStateFundResource {

    private final VariableIncomeService<RealStateFund> variableIncomeService;

    public RealStateFundResource(VariableIncomeService<RealStateFund> variableIncomeService) {
        this.variableIncomeService = variableIncomeService;
    }

    @GetMapping
    public List<VariableIncomeRecord> getRealStateFund() {
        return variableIncomeService.findAll();
    }
}
