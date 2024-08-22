package com.wallet.investment.repositories;

import com.wallet.investment.domain.Stock;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = """
                SELECT tto.ticker, SUM(tto.amount) * ts.preco AS saldo, ts.dat_creation 
                FROM tb_transation_order tto
                INNER JOIN tb_stock ts ON tto.ticker = ts.ticker
                WHERE tto.ticker IN (SELECT DISTINCT tto_inner.ticker FROM tb_transation_order tto_inner)
                  AND ts.dat_creation > :date
                GROUP BY tto.ticker, ts.dat_creation, ts.preco
                ORDER BY ts.dat_creation DESC
            """, nativeQuery = true)
    List<Object[]> findTickerBalancesAfterDate(@Param("date") LocalDateTime date);

    default Stock findLastCreated() {
        return findAll(
                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "datCreation"))
        ).getContent().stream().findFirst().orElse(null);
    }
}
