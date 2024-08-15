package com.wallet.investment.service;

import com.wallet.investment.domain.Stock;
import com.wallet.investment.records.VariableIncomeRecord;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface VariableIncomeService<T> {

    default List<VariableIncomeRecord> variableIncomeRecords(List<Object[]> objects) {
        return objects.stream().map(objectArray -> new VariableIncomeRecord(
                        objectArray[0].toString(),
                        LocalDate.parse(objectArray[2].toString().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        new BigDecimal(objectArray[1].toString())))
                .toList();
    }

    void saveAll(List<T> stockList);

    List<VariableIncomeRecord> findAll();
}
