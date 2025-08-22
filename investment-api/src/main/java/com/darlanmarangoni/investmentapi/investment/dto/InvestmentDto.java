package com.darlanmarangoni.investmentapi.investment.dto;

import com.darlanmarangoni.investmentapi.enums.InvestmentType;

import java.math.BigDecimal;

public record InvestmentDto(
        String ticker,
        Integer amount,
        InvestmentType investmentType,
        BigDecimal total,
        String description
) {
}
