package com.wallet.investment.records;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VariableIncomeItemRecord(
        String tiker,
        LocalDate date,
        BigDecimal value
){}
