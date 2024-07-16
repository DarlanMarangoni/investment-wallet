package com.wallet.investment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_INVESTMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID investmentId;
    private String asset;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
