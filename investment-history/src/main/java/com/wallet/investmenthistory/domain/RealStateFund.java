package com.wallet.investmenthistory.domain;

import com.wallet.investmenthistory.service.BigDecimalUtil;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_real_state_fund")
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

    public RealStateFund() {}

    public RealStateFund(String[] cols) {
        this.ticker = cols[0];
        this.preco = BigDecimalUtil.readValue(cols[1]);
        this.ultimoDividendo = BigDecimalUtil.readValue(cols[2]);
        this.dividendYield = BigDecimalUtil.readValue(cols[3]);
        this.valorPatrimonialCota = BigDecimalUtil.readValue(cols[4]);
        this.pVP = BigDecimalUtil.readValue(cols[5]);
        this.liquidezMediaDiaria = BigDecimalUtil.readValue(cols[6]);
        this.percentualCaixa = BigDecimalUtil.readValue(cols[7]);
        this.cAGRDividendosTresAnos = BigDecimalUtil.readValue(cols[8]);
        this.cAGRValorCotaTresAnos = BigDecimalUtil.readValue(cols[9]);
        this.patrimonio = BigDecimalUtil.readValue(cols[10]);
        this.numeroDeCotista = BigDecimalUtil.readValue(cols[11]);
        this.gestao = cols[12];
        this.numeroCotas = BigDecimalUtil.readValue(cols[13]);
    }
}
