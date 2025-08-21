package com.darlanmarangoni.investmentapi.investment.domain;

import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import com.darlanmarangoni.investmentapi.investment.dto.InvestmentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_INVESTMENT")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public static Investment from(InvestmentDto investmentDto) {
        Investment investment = new Investment();
        BeanUtils.copyProperties(investmentDto, investment);
        return investment;
    }
}
