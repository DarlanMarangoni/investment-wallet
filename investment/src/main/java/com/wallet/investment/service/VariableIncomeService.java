package com.wallet.investment.service;

import com.wallet.investment.records.VariableIncomeItemRecord;
import com.wallet.investment.records.VariableIncomeRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface VariableIncomeService<T> {

    default List<VariableIncomeItemRecord> variableIncomeRecords(List<Object[]> objects) {
        return objects.stream().map(objectArray -> new VariableIncomeItemRecord(
                        objectArray[0].toString(),
                        LocalDate.parse(objectArray[2].toString().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        new BigDecimal(objectArray[1].toString())))
                .toList();
    }

    void saveAll(List<T> stockList);

    VariableIncomeRecord findAll();
}
