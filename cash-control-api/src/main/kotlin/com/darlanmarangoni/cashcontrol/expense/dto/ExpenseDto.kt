package com.darlanmarangoni.cashcontrol.expense.dto

import com.darlanmarangoni.cashcontrol.expense.domain.ExpenseType

data class ExpenseDto(
    val id: Long?,
    val expenseType: ExpenseType,
    val name: String
)