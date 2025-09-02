package com.darlanmarangoni.investmentapi.earning.repository;

import com.darlanmarangoni.investmentapi.earning.domain.Earning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EarningRepository extends JpaRepository<Earning, UUID> {

    Page<Earning> findByUserId(UUID userId, Pageable pageable);

}
