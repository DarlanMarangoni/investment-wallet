package com.darlanmarangoni.cashcontrol.expense.resource

import com.darlanmarangoni.cashcontrol.commons.ObjectNotFoundException
import com.darlanmarangoni.cashcontrol.expense.domain.Expense
import com.darlanmarangoni.cashcontrol.expense.domain.Bill
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

    @PostMapping("/{expenseId}/bills")
    fun addReceive(@PathVariable expenseId: Long, @RequestBody bill: Bill) {
        val expense = expenseRepository.findById(expenseId)
        if (expense.isEmpty) {
            throw ObjectNotFoundException("Expense not found id=$expenseId")
        }
        bill.expense = expense.get()
        billRepository.save(bill)
    }
}