package com.darlanmarangoni.investmentapi.domain;

import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import com.darlanmarangoni.investmentapi.enums.TransactionType;
import com.darlanmarangoni.investmentapi.records.BrockerageNoteRecord;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "TB_TRANSATION_ORDER")
public class TransactionOrder {

    @Id
    @SequenceGenerator(
            name = "tb_transation_order_id_seq",
            sequenceName = "tb_transation_order_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_transation_order_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "TICKER")
    private String ticker;
    @Column(name = "FLG_MERCADO_FRACIONARIO")
    private Boolean isFractionalMarket;
    @Column(name = "investiment_type")
    @Enumerated(EnumType.STRING)
    private InvestmentType investmentType;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "VALUE")
    private BigDecimal value;
    @Column(name = "AMOUNT")
    private Integer amount;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "DAT_CREATION")
    @CreationTimestamp
    private LocalDateTime creationDate;

    public TransactionOrder(String ticker,
                            Boolean isFractionalMarket,
                            InvestmentType investmentType,
                            TransactionType transactionType,
                            BigDecimal value,
                            Integer amount,
                            LocalDate date) {
        this.ticker = ticker;
        this.isFractionalMarket = isFractionalMarket;
        this.investmentType = investmentType;
        this.transactionType = transactionType;
        this.value = value;
        this.amount = amount;
        this.date = date;
    }

    public TransactionOrder() {}

    public static List<TransactionOrder> from(BrockerageNoteRecord brockerageNoteRecord) {
        return brockerageNoteRecord.brockerageNoteRecords()
                .stream()
                .map(dto -> new TransactionOrder(
                        dto.tiker(),
                        dto.isFractionalMarket(),
                        dto.investmentType(),
                        dto.transactionType(),
                        dto.value(),
                        dto.amount(),
                        dto.date()
                )).toList();
    }
}
