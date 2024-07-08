package com.wallet.investment.domain;

import com.wallet.investment.enums.FixedIncomeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "investmentId")
public class FixedIncome extends Investment {

    private BigDecimal value;
    @Enumerated(value = EnumType.STRING)
    private FixedIncomeType fixedIncomeType;

}
