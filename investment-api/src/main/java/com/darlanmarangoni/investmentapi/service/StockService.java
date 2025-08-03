package com.darlanmarangoni.investmentapi.service;

import com.darlanmarangoni.investmentapi.domain.Stock;
import com.darlanmarangoni.investmentapi.repositories.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Stock> findLastCote(Pageable pageable) {
        return stockRepository.findAll(pageable);
    }
}
