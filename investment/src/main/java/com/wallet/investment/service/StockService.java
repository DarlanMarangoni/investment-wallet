package com.wallet.investment.service;

import com.wallet.investment.domain.Stock;
import com.wallet.investment.enums.InvestmentType;
import com.wallet.investment.records.LineChartHomeDataRecord;
import com.wallet.investment.records.VariableIncomeItemRecord;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.records.data.VariableIncomeItemDataRecord;
import com.wallet.investment.repositories.StockRepository;
import com.wallet.investment.util.LocalDateTimeUtil;
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
        var variableIncomeItemDataRecords = variableIncomeRecords(stockRepository
                .findTickerBalancesAfterDate(LocalDateTimeUtil
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
