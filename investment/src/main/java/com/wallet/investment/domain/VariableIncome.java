package com.wallet.investment.domain;

import com.wallet.investment.enums.VariableIncomeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "investmentId")
public class VariableIncome extends Investment {

    private String code;
    private String sektor;
    private String broker;
    private int amount;
    private BigDecimal unitPurchaseValue;
    private LocalDate purchaseDate;
    private BigDecimal unitSaleDate;
    private LocalDate saleDate;
    @Enumerated(value = EnumType.STRING)
    private VariableIncomeType variableIncomeType;

}
