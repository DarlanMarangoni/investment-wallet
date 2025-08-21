package com.darlanmarangoni.investmentapi.domain;

import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_INVESTMENT")
public class Investment {
    @Id
    private UUID id;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "investment_type")
    @Enumerated(EnumType.STRING)
    private InvestmentType investmentType;
}
