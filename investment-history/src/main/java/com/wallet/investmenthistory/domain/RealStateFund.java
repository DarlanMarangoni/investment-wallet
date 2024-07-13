package com.wallet.investmenthistory.domain;

import com.wallet.investmenthistory.service.BigDecimalUtil;

import java.math.BigDecimal;

public class RealStateFund {
//    TICKER;
    private String ticker;
//    PRECO;
    private BigDecimal preco;
//    ULTIMO DIVIDENDO;
    private BigDecimal ultimoDividendo;
//    DY;
    private BigDecimal dividendYield;
//    VALOR PATRIMONIAL COTA;
    private BigDecimal valorPatrimonialCota;
//    P/VP;
    private BigDecimal pVP;
//    LIQUIDEZ MEDIA DIARIA;
    private BigDecimal liquidezMediaDiaria;
//    PERCENTUAL EM CAIXA;
    private BigDecimal percentualCaixa;
//    CAGR DIVIDENDOS 3 ANOS;
    private BigDecimal cAGRDividendosTresAnos;
//    CAGR VALOR CORA 3 ANOS;
    private BigDecimal cAGRValorCotaTresAnos;
//    PATRIMONIO;
    private BigDecimal patrimonio;
//    N COTISTAS;
    private BigDecimal numeroDeCotista;
//    GESTAO;
    private String gestao;
//    N COTAS
    private BigDecimal numeroCotas;

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
