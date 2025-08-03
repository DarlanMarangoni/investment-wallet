package com.darlanmarangoni.investmentapi.repositories;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RealStateFundRepository extends JpaRepository<RealStateFund, Long> {

    @Query(value = """
                SELECT tto.ticker, SUM(tto.amount) * trsf.preco AS saldo, trsf.dat_creation
                FROM tb_transation_order tto
                INNER JOIN tb_real_state_fund trsf ON tto.ticker = trsf.ticker
                WHERE tto.ticker IN :fiis
                  AND trsf.dat_creation > :date
                GROUP BY tto.ticker, trsf.dat_creation, trsf.preco
                ORDER BY trsf.dat_creation DESC
            """, nativeQuery = true)
    List<Object[]> findTickerBalancesAfterDate(@Param("fiis") List<String> fiis, @Param("date") LocalDateTime date);

    default RealStateFund findLastCreated() {
        return findAll(
                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "datCreation"))
        ).getContent().stream().findFirst().orElse(null);
    }

    @Query(value = """
            SELECT SUM(saldo) AS total_saldo
                 , subquery.date_time
            FROM (select sum(amount) * ts.preco                         as saldo
                       , to_char(ts.dat_creation, 'YYYY-MM-DD HH24:MI') as date_time
                  from tb_transation_order tto
                           inner join tb_real_state_fund ts on tto.ticker = ts.ticker
                  where tto.ticker in (select distinct TTO.ticker from tb_transation_order TTO)
                  group by date_time, ts.preco
                  order by date_time desc) as subquery
            group by subquery.date_time
            order by subquery.date_time desc
            """, nativeQuery = true)
    List<Object[]> findValueByGroupByDateTime();
}