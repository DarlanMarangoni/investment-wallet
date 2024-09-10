package com.wallet.investment.service;

import com.wallet.investment.domain.TransactionOrder;
import com.wallet.investment.enums.InvestmentType;
import com.wallet.investment.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransationService {

    private final TransactionRepository transactionRepository;

    public TransationService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public BigDecimal calculateInvestedValue() {
        return transactionRepository.calculateInvestedValue();
    }

    public List<TransactionOrder> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<TransactionOrder> findAllTransactionsByType(InvestmentType investmentType) {
        return transactionRepository.findAllByInvestmentType(investmentType);
    }

}
