package com.wallet.investment.service;

import com.wallet.investment.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransationService {

    private final TransactionRepository transactionRepository;

    public TransationService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

}
