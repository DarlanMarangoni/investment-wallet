package com.darlanmarangoni.investmentapi.records;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record VariableIncomeItemRecord(
        String tiker,
        LocalDate date,
        BigDecimal value,
        BigDecimal percentil
){}
