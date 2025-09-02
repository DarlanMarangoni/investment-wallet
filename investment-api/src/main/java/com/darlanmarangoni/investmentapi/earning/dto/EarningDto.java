package com.darlanmarangoni.investmentapi.earning.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EarningDto(
        String ticker,
        Integer amount,
        BigDecimal total,
        LocalDate date
) {
}
