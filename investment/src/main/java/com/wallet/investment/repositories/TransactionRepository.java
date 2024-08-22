package com.wallet.investment.repositories;

import com.wallet.investment.domain.TransactionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionOrder, Long> {

    @Query(value = """
                   select 
                       coalesce((select sum(value * amount) as total_compra
                           from tb_transation_order where transaction_type = 'PURCHASE'), 0) -
                       coalesce((select sum(value * amount) as total_venda 
                            from tb_transation_order where transaction_type = 'SALE'), 0) as saldo;
            """, nativeQuery = true)
    BigDecimal calculateInvestedValue();
}
