package com.darlanmarangoni.cashcontrol.income.resource

import com.darlanmarangoni.cashcontrol.commons.ObjectNotFoundException
import com.darlanmarangoni.cashcontrol.income.domain.Income
import com.darlanmarangoni.cashcontrol.income.domain.Receive
import com.darlanmarangoni.cashcontrol.income.repository.IncomeRepository
import com.darlanmarangoni.cashcontrol.income.repository.ReceiveRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/incomes")
@CrossOrigin("*")
class IncomeResource(
    val incomeRepository: IncomeRepository,
    val receiveRepository: ReceiveRepository
) {

    @GetMapping
    fun findAllByUserId(@RequestParam(name = "userId", required = true) userId: String): List<Income> {
        return incomeRepository.findAllByUserId(userId)
    }

    @PostMapping
    fun createIncome(@RequestBody income: Income) {
        incomeRepository.save(income)
    }

    @PostMapping("/{incomeId}/receives")
    fun addReceive(@PathVariable incomeId: Long, @RequestBody receive: Receive) {
        val income = incomeRepository.findById(incomeId)
        if (income.isEmpty) {
            throw ObjectNotFoundException("Income not found id=$incomeId")
        }
        receive.income = income.get()
        receiveRepository.save(receive)
    }

    @GetMapping("/receives")
    fun findAllReceives(
        @RequestParam(name = "userId", required = true) userId: String,
        @PageableDefault(
            page = 0,
            size = 10,
            sort = ["date"],
            direction = Sort.Direction.DESC
        ) pageable: Pageable
    ): Page<Receive> {
        return receiveRepository.findAll(pageable);
    }
}