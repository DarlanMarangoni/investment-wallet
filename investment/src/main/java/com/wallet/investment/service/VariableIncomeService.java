package com.wallet.investment.service;

import com.wallet.investment.domain.TransactionOrder;
import com.wallet.investment.enums.TransactionType;
import com.wallet.investment.records.LineChartHomeDataRecord;
import com.wallet.investment.records.VariableIncomeRecord;
import com.wallet.investment.records.data.VariableIncomeItemDataRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    default List<String> filterPositive(List<TransactionOrder> items) {
        var map = new HashMap<String, BigDecimal>();
        items.forEach(item -> {
            BigDecimal saldo = item.getValue().multiply(new BigDecimal(item.getAmount()));;
            if (item.getTransactionType().equals(TransactionType.SALE)) {
                saldo = saldo.multiply(new BigDecimal("-1"));
            }
            if (map.get(item.getTicker()) == null) {
                map.put(item.getTicker(), saldo);
            } else {
                BigDecimal bigDecimal = map.get(item.getTicker());
                map.replace(item.getTicker(), bigDecimal.add(saldo));
            }
        });
        return map.entrySet()
                .stream()
                .filter(f -> f.getValue().compareTo(BigDecimal.ZERO) > 0)
                .map(Map.Entry::getKey)
                .toList();
    }
}
