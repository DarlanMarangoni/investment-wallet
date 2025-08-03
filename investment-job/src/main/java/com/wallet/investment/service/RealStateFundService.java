package com.wallet.investment.service;

import com.wallet.investment.domain.RealStateFund;
import com.wallet.investment.repositories.RealStateFundRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealStateFundService implements VariableIncomeService<RealStateFund> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealStateFundService.class);

    final RealStateFundRepository realStateFundRepository;
    final TransationService transationService;

    public RealStateFundService(RealStateFundRepository realStateFundRepository, TransationService transationService) {
        this.realStateFundRepository = realStateFundRepository;
        this.transationService = transationService;
    }

    @Override
    @Transactional
    public void saveAll(List<RealStateFund> stockList) {
        realStateFundRepository.saveAll(stockList);
        LOGGER.info("Persisted {} realStateFunds", stockList.size());
    }
}
