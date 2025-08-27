package com.darlanmarangoni.investmentapi.repositories;

import com.darlanmarangoni.investmentapi.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findFirstByTickerOrderByDatCreationDesc(String tiker);


}
