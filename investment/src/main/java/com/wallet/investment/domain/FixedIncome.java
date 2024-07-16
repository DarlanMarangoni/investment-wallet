package com.wallet.investment.domain;

import com.wallet.investment.enums.FixedIncomeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TB_FIXED_INCOME")
@PrimaryKeyJoinColumn(name = "investmentId")
public class FixedIncome extends Investment {

    private BigDecimal value;
    @Enumerated(value = EnumType.STRING)
    private FixedIncomeType fixedIncomeType;

}
