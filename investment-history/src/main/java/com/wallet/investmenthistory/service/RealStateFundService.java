package com.wallet.investmenthistory.service;

import com.wallet.investmenthistory.RealStateFundRepository;
import com.wallet.investmenthistory.domain.RealStateFund;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class RealStateFundService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealStateFundService.class);

    final RealStateFundRepository realStateFundRepository;

    public RealStateFundService(RealStateFundRepository realStateFundRepository) {
        this.realStateFundRepository = realStateFundRepository;
    }

    @Transactional
    public void persist(List<RealStateFund> stockList) {
        realStateFundRepository.persist(stockList);
        LOGGER.info("Persisted {} realStateFunds", stockList.size());
    }
}
