package com.darlanmarangoni.investmentapi.investment.repositories;

import com.darlanmarangoni.investmentapi.investment.domain.Investment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, UUID> {

    Page<Investment> findByUserId(UUID userId, Pageable pageable);

    List<Investment> findByTickerAndUserId(String tiker , UUID userId);

}
