package com.darlanmarangoni.investmentapi.domain;

import com.darlanmarangoni.investmentapi.util.BigDecimalUtil;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getUltimoDividendo() {
        return ultimoDividendo;
    }

    public void setUltimoDividendo(BigDecimal ultimoDividendo) {
        this.ultimoDividendo = ultimoDividendo;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
    }

    public BigDecimal getValorPatrimonialCota() {
        return valorPatrimonialCota;
    }

    public void setValorPatrimonialCota(BigDecimal valorPatrimonialCota) {
        this.valorPatrimonialCota = valorPatrimonialCota;
    }

    public BigDecimal getpVP() {
        return pVP;
    }

    public void setpVP(BigDecimal pVP) {
        this.pVP = pVP;
    }

    public BigDecimal getLiquidezMediaDiaria() {
        return liquidezMediaDiaria;
    }

    public void setLiquidezMediaDiaria(BigDecimal liquidezMediaDiaria) {
        this.liquidezMediaDiaria = liquidezMediaDiaria;
    }

    public BigDecimal getPercentualCaixa() {
        return percentualCaixa;
    }

    public void setPercentualCaixa(BigDecimal percentualCaixa) {
        this.percentualCaixa = percentualCaixa;
    }

    public BigDecimal getcAGRDividendosTresAnos() {
        return cAGRDividendosTresAnos;
    }

    public void setcAGRDividendosTresAnos(BigDecimal cAGRDividendosTresAnos) {
        this.cAGRDividendosTresAnos = cAGRDividendosTresAnos;
    }

    public BigDecimal getcAGRValorCotaTresAnos() {
        return cAGRValorCotaTresAnos;
    }

    public void setcAGRValorCotaTresAnos(BigDecimal cAGRValorCotaTresAnos) {
        this.cAGRValorCotaTresAnos = cAGRValorCotaTresAnos;
    }

    public BigDecimal getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(BigDecimal patrimonio) {
        this.patrimonio = patrimonio;
    }

    public BigDecimal getNumeroDeCotista() {
        return numeroDeCotista;
    }

    public void setNumeroDeCotista(BigDecimal numeroDeCotista) {
        this.numeroDeCotista = numeroDeCotista;
    }

    public String getGestao() {
        return gestao;
    }

    public void setGestao(String gestao) {
        this.gestao = gestao;
    }

    public BigDecimal getNumeroCotas() {
        return numeroCotas;
    }

    public void setNumeroCotas(BigDecimal numeroCotas) {
        this.numeroCotas = numeroCotas;
    }

    public LocalDateTime getDatCreation() {
        return datCreation;
    }

    public void setDatCreation(LocalDateTime datCreation) {
        this.datCreation = datCreation;
    }
}
