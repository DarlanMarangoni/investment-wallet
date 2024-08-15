package com.wallet.investment.service;

import com.wallet.investment.domain.Stock;
import com.wallet.investment.enums.InvestmentType;
import com.wallet.investment.records.VariableIncomeItemRecord;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.repositories.StockRepository;
import com.wallet.investment.util.LocalDateTimeUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StockService implements VariableIncomeService<Stock> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    @Transactional
    public void saveAll(List<Stock> stockList) {
        stockRepository.saveAll(stockList);
        LOGGER.info("Persisted {} stocks", stockList.size());
    }

    @Override
    public VariableIncomeRecord findAll() {
        var variableIncomeItemRecords = variableIncomeRecords(stockRepository
                .findTickerBalancesAfterDate(LocalDateTimeUtil
                        .roundSeconds(stockRepository.findLastCreated().getDatCreation())));
        var reduce = variableIncomeItemRecords.stream()
                .map(VariableIncomeItemRecord::value)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new VariableIncomeRecord(
                InvestmentType.STOCK.getType(),
                reduce,
                variableIncomeItemRecords
        );
    }
}
