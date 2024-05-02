package com.darlanmarangoni.cashcontrol.income.repository

import com.darlanmarangoni.cashcontrol.income.domain.Income
import org.springframework.data.jpa.repository.JpaRepository

interface IncomeRepository: JpaRepository<Income, Long> {
    fun findAllByUserId(userId: String): List<Income>
}