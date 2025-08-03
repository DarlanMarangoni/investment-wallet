package com.wallet.investment.repositories;

import com.wallet.investment.domain.TransactionOrder;
import com.wallet.investment.enums.InvestmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionOrder, Long> {}
