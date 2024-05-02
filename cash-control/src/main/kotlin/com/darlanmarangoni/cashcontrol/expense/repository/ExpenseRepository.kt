package com.darlanmarangoni.cashcontrol.expense.repository

import com.darlanmarangoni.cashcontrol.expense.domain.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<Expense, Long> {

    fun findAllByUserId(userId: String): List<Expense>
}