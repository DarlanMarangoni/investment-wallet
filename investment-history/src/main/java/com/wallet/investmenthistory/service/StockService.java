package com.wallet.investmenthistory.service;

import com.wallet.investmenthistory.RawBackgroundFunctionPubSub;
import com.wallet.investmenthistory.StockRepository;
import com.wallet.investmenthistory.domain.Stock;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class StockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void persist(List<Stock> stockList) {
        stockRepository.persist(stockList);
        LOGGER.info("Persisted {} stocks", stockList.size());
    }
}
