package com.darlanmarangoni.cashcontrol.expense.resource

import com.darlanmarangoni.cashcontrol.commons.ObjectNotFoundException
import com.darlanmarangoni.cashcontrol.expense.domain.Expense
import com.darlanmarangoni.cashcontrol.expense.domain.Bill
import com.darlanmarangoni.cashcontrol.expense.dto.BillDto
import com.darlanmarangoni.cashcontrol.expense.dto.ExpenseDto
import com.darlanmarangoni.cashcontrol.expense.repository.ExpenseRepository
import com.darlanmarangoni.cashcontrol.expense.repository.BillRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/expenses")
class ExpenseResource(
    val expenseRepository: ExpenseRepository,
    val billRepository: BillRepository
) {

    @GetMapping
    fun findAllByUserId(@RequestParam(name = "userId", required = true) userId: String): List<ExpenseDto> {
        return expenseRepository.findAllByUserId(userId)
            .map { ExpenseDto(name = it.name, expenseType = it.expenseType, id = it.id) }
    }

    @PostMapping("/{userId}")
    fun createExpense(@PathVariable userId: String, @RequestBody expenses: List<ExpenseDto>) {
        expenseRepository.saveAll(
            expenses.map { Expense(
                userId = userId,
                expenseType = it.expenseType,
                name = it.name
            ) }
        )
    }

    @PostMapping("/{userId}/bills")
    fun addReceive(@PathVariable userId: String, @RequestBody bill: BillDto) {
        val expense = expenseRepository.findById(bill.expenseId)
        if (expense.isEmpty) {
            throw ObjectNotFoundException("Expense not found id=${bill.expenseId}")
        }
        billRepository.save(Bill(
            expense = expense.get(),
            date = bill.date,
            projected = bill.projected,
            actual = bill.actual
        ))
    }
}