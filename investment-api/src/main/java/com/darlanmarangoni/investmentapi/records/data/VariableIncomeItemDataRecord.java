package com.darlanmarangoni.investmentapi.records.data;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record VariableIncomeItemDataRecord(
        String tiker,
        BigDecimal value,
        LocalDate date
){}
