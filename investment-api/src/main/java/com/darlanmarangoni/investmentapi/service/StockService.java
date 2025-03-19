package com.darlanmarangoni.investmentapi.service;
import com.darlanmarangoni.investmentapi.domain.Stock;
import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import com.darlanmarangoni.investmentapi.records.LineChartHomeDataRecord;
import com.darlanmarangoni.investmentapi.records.VariableIncomeItemRecord;
import com.darlanmarangoni.investmentapi.records.VariableIncomeRecord;
import com.darlanmarangoni.investmentapi.records.data.VariableIncomeItemDataRecord;
import com.darlanmarangoni.investmentapi.repositories.StockRepository;
import com.darlanmarangoni.investmentapi.util.LocalDateTimeUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Override
    public VariableIncomeRecord findAll() {
        var stocks = filterPositive(transationService.findAllTransactionsByType(InvestmentType.STOCK));
        var variableIncomeItemDataRecords = variableIncomeRecords(stockRepository
                .findTickerBalancesAfterDate(stocks, LocalDateTimeUtil
                        .roundSeconds(stockRepository.findLastCreated().getDatCreation())));
        var reduce = variableIncomeItemDataRecords.stream()
                .map(VariableIncomeItemDataRecord::value)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new VariableIncomeRecord(
                InvestmentType.STOCK.getDescription(),
                reduce,
                variableIncomeItemDataRecords.stream().map(m -> new VariableIncomeItemRecord(
                        m.tiker(),
                        m.date(),
                        m.value(),
                        m.value().divide(reduce,new MathContext(10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100))
                )).toList()
        );
    }

    @Override
    public BigDecimal currentValue() {
        return findAll().total();
    }

    @Override
    public List<LineChartHomeDataRecord> findAllByDay() {
        return stockRepository.findValueByGroupByDateTime().stream().map(objects -> new LineChartHomeDataRecord(
                new BigDecimal(String.valueOf(objects[0])),
                LocalDateTime.parse(String.valueOf(objects[1]), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))))
                .toList();
    }
}
