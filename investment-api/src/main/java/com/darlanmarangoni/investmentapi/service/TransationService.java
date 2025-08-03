package com.darlanmarangoni.investmentapi.service;

import com.darlanmarangoni.investmentapi.domain.TransactionOrder;
import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import com.darlanmarangoni.investmentapi.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransationService {

    private final TransactionRepository transactionRepository;

    public TransationService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionOrder> findAllTransactionsByType(InvestmentType investmentType) {
        return transactionRepository.findAllByInvestmentType(investmentType);
    }

}
