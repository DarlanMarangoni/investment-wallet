package com.darlanmarangoni.investmentapi.service;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import com.darlanmarangoni.investmentapi.records.LineChartHomeDataRecord;
import com.darlanmarangoni.investmentapi.records.VariableIncomeItemRecord;
import com.darlanmarangoni.investmentapi.records.VariableIncomeRecord;
import com.darlanmarangoni.investmentapi.records.data.VariableIncomeItemDataRecord;
import com.darlanmarangoni.investmentapi.repositories.RealStateFundRepository;
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

    @Override
    public VariableIncomeRecord findAll() {
        var fiis = filterPositive(transationService.findAllTransactionsByType(InvestmentType.FII));
        var variableIncomeItemDataRecords = variableIncomeRecords(realStateFundRepository
                .findTickerBalancesAfterDate(fiis, LocalDateTimeUtil
                        .roundSeconds(realStateFundRepository.findLastCreated().getDatCreation())));
        var reduce = variableIncomeItemDataRecords.stream()
                .map(VariableIncomeItemDataRecord::value)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new VariableIncomeRecord(
                InvestmentType.FII.getDescription(),
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
        return realStateFundRepository.findValueByGroupByDateTime().stream().map(objects -> new LineChartHomeDataRecord(
                        new BigDecimal(String.valueOf(objects[0])),
                        LocalDateTime.parse(String.valueOf(objects[1]), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))))
                .toList();
    }
}
