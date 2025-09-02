package com.darlanmarangoni.investmentapi.earning.domain;

import com.darlanmarangoni.investmentapi.earning.dto.EarningDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_EARNING")
public class Earning {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "userId")
    private UUID userId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "date")
    private LocalDate date;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public static Earning from(EarningDto earningDto) {
        Earning earning = new Earning();
        BeanUtils.copyProperties(earningDto, earning);
        return earning;
    }

}
