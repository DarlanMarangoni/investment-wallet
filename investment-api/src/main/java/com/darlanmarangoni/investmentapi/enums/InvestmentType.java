package com.darlanmarangoni.investmentapi.enums;

public enum InvestmentType {

    STOCK("1", "Ações"),
    FII("2", "Fundos imobiliarios");

    private final String type;
    private final String description;

    InvestmentType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
