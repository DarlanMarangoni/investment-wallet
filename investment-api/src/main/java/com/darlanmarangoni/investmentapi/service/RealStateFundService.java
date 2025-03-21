package com.darlanmarangoni.investmentapi.service;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import com.darlanmarangoni.investmentapi.repositories.RealStateFundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RealStateFundService implements VariableIncomeService<RealStateFund> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealStateFundService.class);

    final RealStateFundRepository realStateFundRepository;
    final TransationService transationService;

    public RealStateFundService(RealStateFundRepository realStateFundRepository, TransationService transationService) {
        this.realStateFundRepository = realStateFundRepository;
        this.transationService = transationService;
    }

}
