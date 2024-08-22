package com.wallet.investment.records;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.wallet.investment.enums.InvestmentType;
import com.wallet.investment.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionOrderRecord(
        String tiker,
        Boolean isFractionalMarket,
        InvestmentType investmentType,
        TransactionType transactionType,
        BigDecimal value,
        Integer amount,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate date
) {}
