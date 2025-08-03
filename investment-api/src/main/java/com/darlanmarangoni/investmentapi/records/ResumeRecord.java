package com.darlanmarangoni.investmentapi.records;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ResumeRecord(
        BigDecimal currentValue,
        BigDecimal investedValue
){}
