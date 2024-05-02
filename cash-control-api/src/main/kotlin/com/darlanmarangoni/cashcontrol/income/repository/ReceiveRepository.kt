package com.darlanmarangoni.cashcontrol.income.repository

import com.darlanmarangoni.cashcontrol.income.domain.Receive
import org.springframework.data.jpa.repository.JpaRepository

interface ReceiveRepository: JpaRepository<Receive, Long> {
}