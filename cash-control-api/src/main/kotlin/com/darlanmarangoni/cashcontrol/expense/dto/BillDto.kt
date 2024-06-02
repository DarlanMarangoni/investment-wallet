package com.darlanmarangoni.cashcontrol.expense.dto

import java.math.BigDecimal
import java.time.LocalDate

data class BillDto(
    val date: LocalDate,
    val projected: BigDecimal,
    val actual: BigDecimal,
    val expenseId: Long
)