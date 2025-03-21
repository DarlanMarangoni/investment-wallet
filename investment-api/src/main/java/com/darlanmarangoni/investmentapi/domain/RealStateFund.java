package com.darlanmarangoni.investmentapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_REAL_STATE_FUND")
public class RealStateFund {

    @Id
    @SequenceGenerator(
            name = "tb_real_state_fund_id_seq",
            sequenceName = "tb_real_state_fund_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_real_state_fund_id_seq")

    @Column(name = "id")
    private Long id;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "ultimo_dividendo")
    private BigDecimal ultimoDividendo;
    @Column(name = "dy")
    private BigDecimal dividendYield;
    @Column(name = "valor_patrimonial_cota")
    private BigDecimal valorPatrimonialCota;
    @Column(name = "p_vp")
    private BigDecimal pVP;
    @Column(name = "liquidez_media_diaria")
    private BigDecimal liquidezMediaDiaria;
    @Column(name = "percentual_em_caixa")
    private BigDecimal percentualCaixa;
    @Column(name = "cagr_dividendos_3_anos")
    private BigDecimal cAGRDividendosTresAnos;
    @Column(name = "cagr_valor_cota_3_anos")
    private BigDecimal cAGRValorCotaTresAnos;
    @Column(name = "patrimonio")
    private BigDecimal patrimonio;
    @Column(name = "n_cotistas")
    private BigDecimal numeroDeCotista;
    @Column(name = "gestao")
    private String gestao;
    @Column(name = "n_cotas")
    private BigDecimal numeroCotas;
    @Column(name = "dat_creation")
    @CreationTimestamp
    private LocalDateTime datCreation;

}
