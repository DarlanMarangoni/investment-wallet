package com.darlanmarangoni.investmentapi.records;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record VariableIncomeRecord(
        String type,
        BigDecimal total,
        List<VariableIncomeItemRecord> variableIncomeItemRecordList
){}
