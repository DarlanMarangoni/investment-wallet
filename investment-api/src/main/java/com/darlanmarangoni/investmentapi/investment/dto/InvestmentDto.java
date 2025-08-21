package com.darlanmarangoni.investmentapi.investment.dto;

import com.darlanmarangoni.investmentapi.enums.InvestmentType;

public record InvestmentDto(
        String ticker,
        Integer amount,
        InvestmentType investmentType
) {
}
