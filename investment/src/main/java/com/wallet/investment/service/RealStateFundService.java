package com.wallet.investment.service;

import com.wallet.investment.domain.RealStateFund;
import com.wallet.investment.enums.InvestmentType;
import com.wallet.investment.records.VariableIncomeItemRecord;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.repositories.RealStateFundRepository;
import com.wallet.investment.util.LocalDateTimeUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RealStateFundService implements VariableIncomeService<RealStateFund> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealStateFundService.class);

    final RealStateFundRepository realStateFundRepository;

    public RealStateFundService(RealStateFundRepository realStateFundRepository) {
        this.realStateFundRepository = realStateFundRepository;
    }

    @Override
    @Transactional
    public void saveAll(List<RealStateFund> stockList) {
        realStateFundRepository.saveAll(stockList);
        LOGGER.info("Persisted {} realStateFunds", stockList.size());
    }

    @Override
    public VariableIncomeRecord findAll() {
        var variableIncomeItemRecords = variableIncomeRecords(realStateFundRepository
                .findTickerBalancesAfterDate(LocalDateTimeUtil
                        .roundSeconds(realStateFundRepository.findLastCreated().getDatCreation())));
        var reduce = variableIncomeItemRecords.stream()
                .map(VariableIncomeItemRecord::value)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new VariableIncomeRecord(
                InvestmentType.FII.getType(),
                reduce,
                variableIncomeItemRecords
        );
    }
}
