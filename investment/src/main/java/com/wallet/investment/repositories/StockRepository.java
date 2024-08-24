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

    @Query(value = """
            SELECT SUM(saldo) AS total_saldo
                 , subquery.date_time
            FROM (select sum(amount) * ts.preco                         as saldo
                       , to_char(ts.dat_creation, 'YYYY-MM-DD HH24:MI') as date_time
                  from tb_transation_order tto
                           inner join tb_stock ts on tto.ticker = ts.ticker
                  where tto.ticker in (select distinct TTO.ticker from tb_transation_order TTO)
                  group by date_time, ts.preco
                  order by date_time desc) as subquery
            group by subquery.date_time
            order by subquery.date_time desc
            """, nativeQuery = true)
    List<Object[]> findValueByGroupByDateTime();

    default Stock findLastCreated() {
        return findAll(
                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "datCreation"))
        ).getContent().stream().findFirst().orElse(null);
    }
}
