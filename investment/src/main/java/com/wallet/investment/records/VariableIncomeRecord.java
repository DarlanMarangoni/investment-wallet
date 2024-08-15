package com.wallet.investment.records;

import java.math.BigDecimal;
import java.util.List;

public record VariableIncomeRecord(
        String type,
        BigDecimal total,
        List<VariableIncomeItemRecord> variableIncomeItemRecordList
){}
