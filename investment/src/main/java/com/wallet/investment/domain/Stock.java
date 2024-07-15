package com.wallet.investment.domain;

import com.wallet.investment.util.BigDecimalUtil;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_STOCK")
public class Stock {

    @Id
    @SequenceGenerator(
            name = "tb_stock_id_seq",
            sequenceName = "tb_stock_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_stock_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "dy")
    private BigDecimal dividendYield;
    @Column(name = "pl")
    private BigDecimal pL;
    @Column(name = "p_vp")
    private BigDecimal pVP;
    @Column(name = "p_ativos")
    private BigDecimal pAtivos;
    @Column(name = "margem_bruta")
    private BigDecimal margemBruta;
    @Column(name = "margem_ebit")
    private BigDecimal margemEbit;
    @Column(name = "marg_liquida")
    private BigDecimal margemLiquida;
    @Column(name = "p_ebit")
    private BigDecimal pEbit;
    @Column(name = "ev_ebit")
    private BigDecimal evEbit;
    @Column(name = "divida_liquida_ebit")
    private BigDecimal dividaLiquidaEbit;
    @Column(name = "div_liquida_patrimonio")
    private BigDecimal DivLiqPatri;
    @Column(name = "psr")
    private BigDecimal pSR;
    @Column(name = "p_cap_giro")
    private BigDecimal pCapGiro;
    @Column(name = "p_at_cir_liq")
    private BigDecimal pAtCirLiq;
    @Column(name = "liq_corrente")
    private BigDecimal liqCorrente;
    @Column(name = "roe")
    private BigDecimal rOE;
    @Column(name = "roa")
    private BigDecimal rOA;
    @Column(name = "roic")
    private BigDecimal rOIC;
    @Column(name = "patrimonio_ativos")
    private BigDecimal patrimonioAtivos;
    @Column(name = "passivos_ativos")
    private BigDecimal passivosAtivos;
    @Column(name = "giro_ativos")
    private BigDecimal giroAtivos;
    @Column(name = "cagr_receitas_5_anos")
    private BigDecimal cAGRReceitas5Anos;
    @Column(name = "cagr_lucros_5_anos")
    private BigDecimal cAGRLucros5Anos;
    @Column(name = "liquidez_media_diaria")
    private BigDecimal liquidezMediaDiaria;
    @Column(name = "vpa")
    private BigDecimal vPA;
    @Column(name = "lpa")
    private BigDecimal lPA;
    @Column(name = "peg_ratio")
    private BigDecimal pegRatio;
    @Column(name = "valor_mercado")
    private BigDecimal valorMercado;
    @Column(name = "dat_creation")
    @CreationTimestamp
    private LocalDateTime datCreation;

    public Stock() {
    }

    public Stock(String[] cols) {
        this.ticker = cols[0];
        this.preco = BigDecimalUtil.readValue(cols[1]);
        this.dividendYield = BigDecimalUtil.readValue(cols[2]);
        this.pL = BigDecimalUtil.readValue(cols[3]);
        this.pVP = BigDecimalUtil.readValue(cols[4]);
        this.pAtivos = BigDecimalUtil.readValue(cols[5]);
        this.margemBruta = BigDecimalUtil.readValue(cols[6]);
        this.margemEbit = BigDecimalUtil.readValue(cols[7]);
        this.margemLiquida = BigDecimalUtil.readValue(cols[8]);
        this.pEbit = BigDecimalUtil.readValue(cols[9]);
        this.evEbit = BigDecimalUtil.readValue(cols[10]);
        this.dividaLiquidaEbit = BigDecimalUtil.readValue(cols[11]);
        this.DivLiqPatri = BigDecimalUtil.readValue(cols[12]);
        this.pSR = BigDecimalUtil.readValue(cols[13]);
        this.pCapGiro = BigDecimalUtil.readValue(cols[14]);
        this.pAtCirLiq = BigDecimalUtil.readValue(cols[15]);
        this.liqCorrente = BigDecimalUtil.readValue(cols[16]);
        this.rOE = BigDecimalUtil.readValue(cols[17]);
        this.rOA = BigDecimalUtil.readValue(cols[18]);
        this.rOIC = BigDecimalUtil.readValue(cols[19]);
        this.patrimonioAtivos = BigDecimalUtil.readValue(cols[20]);
        this.passivosAtivos = BigDecimalUtil.readValue(cols[21]);
        this.giroAtivos = BigDecimalUtil.readValue(cols[22]);
        this.cAGRReceitas5Anos = BigDecimalUtil.readValue(cols[23]);
        this.cAGRLucros5Anos = BigDecimalUtil.readValue(cols[24]);
        this.liquidezMediaDiaria = BigDecimalUtil.readValue(cols[25]);
        this.vPA = BigDecimalUtil.readValue(cols[26]);
        this.lPA = BigDecimalUtil.readValue(cols[27]);
        this.pegRatio = BigDecimalUtil.readValue(cols[28]);
        this.valorMercado = BigDecimalUtil.readValue(cols[29]);
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

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
    }

    public BigDecimal getpL() {
        return pL;
    }

    public void setpL(BigDecimal pL) {
        this.pL = pL;
    }

    public BigDecimal getpVP() {
        return pVP;
    }

    public void setpVP(BigDecimal pVP) {
        this.pVP = pVP;
    }

    public BigDecimal getpAtivos() {
        return pAtivos;
    }

    public void setpAtivos(BigDecimal pAtivos) {
        this.pAtivos = pAtivos;
    }

    public BigDecimal getMargemBruta() {
        return margemBruta;
    }

    public void setMargemBruta(BigDecimal margemBruta) {
        this.margemBruta = margemBruta;
    }

    public BigDecimal getMargemEbit() {
        return margemEbit;
    }

    public void setMargemEbit(BigDecimal margemEbit) {
        this.margemEbit = margemEbit;
    }

    public BigDecimal getMargemLiquida() {
        return margemLiquida;
    }

    public void setMargemLiquida(BigDecimal margemLiquida) {
        this.margemLiquida = margemLiquida;
    }

    public BigDecimal getpEbit() {
        return pEbit;
    }

    public void setpEbit(BigDecimal pEbit) {
        this.pEbit = pEbit;
    }

    public BigDecimal getEvEbit() {
        return evEbit;
    }

    public void setEvEbit(BigDecimal evEbit) {
        this.evEbit = evEbit;
    }

    public BigDecimal getDividaLiquidaEbit() {
        return dividaLiquidaEbit;
    }

    public void setDividaLiquidaEbit(BigDecimal dividaLiquidaEbit) {
        this.dividaLiquidaEbit = dividaLiquidaEbit;
    }

    public BigDecimal getDivLiqPatri() {
        return DivLiqPatri;
    }

    public void setDivLiqPatri(BigDecimal divLiqPatri) {
        DivLiqPatri = divLiqPatri;
    }

    public BigDecimal getpSR() {
        return pSR;
    }

    public void setpSR(BigDecimal pSR) {
        this.pSR = pSR;
    }

    public BigDecimal getpCapGiro() {
        return pCapGiro;
    }

    public void setpCapGiro(BigDecimal pCapGiro) {
        this.pCapGiro = pCapGiro;
    }

    public BigDecimal getpAtCirLiq() {
        return pAtCirLiq;
    }

    public void setpAtCirLiq(BigDecimal pAtCirLiq) {
        this.pAtCirLiq = pAtCirLiq;
    }

    public BigDecimal getLiqCorrente() {
        return liqCorrente;
    }

    public void setLiqCorrente(BigDecimal liqCorrente) {
        this.liqCorrente = liqCorrente;
    }

    public BigDecimal getrOE() {
        return rOE;
    }

    public void setrOE(BigDecimal rOE) {
        this.rOE = rOE;
    }

    public BigDecimal getrOA() {
        return rOA;
    }

    public void setrOA(BigDecimal rOA) {
        this.rOA = rOA;
    }

    public BigDecimal getrOIC() {
        return rOIC;
    }

    public void setrOIC(BigDecimal rOIC) {
        this.rOIC = rOIC;
    }

    public BigDecimal getPatrimonioAtivos() {
        return patrimonioAtivos;
    }

    public void setPatrimonioAtivos(BigDecimal patrimonioAtivos) {
        this.patrimonioAtivos = patrimonioAtivos;
    }

    public BigDecimal getPassivosAtivos() {
        return passivosAtivos;
    }

    public void setPassivosAtivos(BigDecimal passivosAtivos) {
        this.passivosAtivos = passivosAtivos;
    }

    public BigDecimal getGiroAtivos() {
        return giroAtivos;
    }

    public void setGiroAtivos(BigDecimal giroAtivos) {
        this.giroAtivos = giroAtivos;
    }

    public BigDecimal getcAGRReceitas5Anos() {
        return cAGRReceitas5Anos;
    }

    public void setcAGRReceitas5Anos(BigDecimal cAGRReceitas5Anos) {
        this.cAGRReceitas5Anos = cAGRReceitas5Anos;
    }

    public BigDecimal getcAGRLucros5Anos() {
        return cAGRLucros5Anos;
    }

    public void setcAGRLucros5Anos(BigDecimal cAGRLucros5Anos) {
        this.cAGRLucros5Anos = cAGRLucros5Anos;
    }

    public BigDecimal getLiquidezMediaDiaria() {
        return liquidezMediaDiaria;
    }

    public void setLiquidezMediaDiaria(BigDecimal liquidezMediaDiaria) {
        this.liquidezMediaDiaria = liquidezMediaDiaria;
    }

    public BigDecimal getvPA() {
        return vPA;
    }

    public void setvPA(BigDecimal vPA) {
        this.vPA = vPA;
    }

    public BigDecimal getlPA() {
        return lPA;
    }

    public void setlPA(BigDecimal lPA) {
        this.lPA = lPA;
    }

    public BigDecimal getPegRatio() {
        return pegRatio;
    }

    public void setPegRatio(BigDecimal pegRatio) {
        this.pegRatio = pegRatio;
    }

    public BigDecimal getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(BigDecimal valorMercado) {
        this.valorMercado = valorMercado;
    }

    public LocalDateTime getDatCreation() {
        return datCreation;
    }

    public void setDatCreation(LocalDateTime datCreation) {
        this.datCreation = datCreation;
    }
}
