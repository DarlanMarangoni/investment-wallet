package com.wallet.investment.service;

import com.wallet.investment.records.LineChartHomeDataRecord;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.records.data.VariableIncomeItemDataRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface VariableIncomeService<T> {

    default List<VariableIncomeItemDataRecord> variableIncomeRecords(List<Object[]> objects) {
        return objects.stream().map(objectArray -> new VariableIncomeItemDataRecord(
                        objectArray[0].toString(),
                        new BigDecimal(objectArray[1].toString()),
                        LocalDate.parse(objectArray[2].toString().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .toList();
    }

    void saveAll(List<T> stockList);

    VariableIncomeRecord findAll();

    BigDecimal currentValue();

    List<LineChartHomeDataRecord> findAllByDay();
}
