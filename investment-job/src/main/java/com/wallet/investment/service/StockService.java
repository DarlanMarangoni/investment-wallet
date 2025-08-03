package com.wallet.investment.service;

import com.wallet.investment.domain.Stock;
import com.wallet.investment.repositories.StockRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService implements VariableIncomeService<Stock> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    final StockRepository stockRepository;
    final TransationService transationService;

    public StockService(StockRepository stockRepository, TransationService transationService) {
        this.stockRepository = stockRepository;
        this.transationService = transationService;
    }

    @Override
    @Transactional
    public void saveAll(List<Stock> stockList) {
        stockRepository.saveAll(stockList);
        LOGGER.info("Persisted {} stocks", stockList.size());
    }
}
