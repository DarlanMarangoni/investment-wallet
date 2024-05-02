package com.darlanmarangoni.cashcontrol.expense.repository

import com.darlanmarangoni.cashcontrol.expense.domain.Bill
import org.springframework.data.jpa.repository.JpaRepository

interface BillRepository: JpaRepository<Bill, Long>