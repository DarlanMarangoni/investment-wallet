package com.darlanmarangoni.investmentapi.enums;

public enum InvestmentType {

    STOCK("Ações"),
    FII("Fundos imobiliarios"),
    FIXED_INCOMING("Renda fixa"),
    PRIVATE_PENSION("Previdencia privada"),
    FGTS("Fundo de garantia por tempo de servico");

    private final String description;

    InvestmentType(String description) {
        this.description = description;
    }
}
