package com.darlanmarangoni.cashcontrol.income.domain

import org.yaml.snakeyaml.TypeDescription

enum class IncomeType(description: String) {
    ACTIVE_INCOME("Renda ativa"),
    PASSIVE_INCOME("Renda passiva")
}