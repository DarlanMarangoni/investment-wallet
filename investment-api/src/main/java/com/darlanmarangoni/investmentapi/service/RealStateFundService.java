package com.darlanmarangoni.investmentapi.service;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import com.darlanmarangoni.investmentapi.repositories.RealStateFundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RealStateFundService implements VariableIncomeService<RealStateFund> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealStateFundService.class);

    final RealStateFundRepository realStateFundRepository;

    public RealStateFundService(RealStateFundRepository realStateFundRepository) {
        this.realStateFundRepository = realStateFundRepository;
    }


    @Override
    public Page<RealStateFund> findLastCote(Pageable pageable) {
        return realStateFundRepository.findAll(pageable);
    }
}
