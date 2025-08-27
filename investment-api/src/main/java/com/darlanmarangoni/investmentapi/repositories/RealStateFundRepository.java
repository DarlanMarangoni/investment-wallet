package com.darlanmarangoni.investmentapi.repositories;

import com.darlanmarangoni.investmentapi.domain.RealStateFund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealStateFundRepository extends JpaRepository<RealStateFund, Long> {

    Optional<RealStateFund> findFirstByTickerOrderByDatCreationDesc(String ticker);

}