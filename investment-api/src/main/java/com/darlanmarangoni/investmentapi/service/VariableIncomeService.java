package com.darlanmarangoni.investmentapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VariableIncomeService<T> {

    Page<T> findLastCote(Pageable pageable);
}
