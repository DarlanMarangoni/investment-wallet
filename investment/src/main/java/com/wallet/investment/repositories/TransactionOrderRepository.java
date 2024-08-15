package com.wallet.investment.repositories;

import com.wallet.investment.domain.TransactionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionOrderRepository extends JpaRepository<TransactionOrder, Long> {
}
