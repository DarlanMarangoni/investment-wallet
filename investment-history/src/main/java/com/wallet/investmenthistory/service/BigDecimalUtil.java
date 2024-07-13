package com.wallet.investmenthistory.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class BigDecimalUtil {

    private BigDecimalUtil() {}

    public static BigDecimal readValue(String value) {
        if (value.isBlank()) {
            return null;
        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        String pattern = "#,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        try {
            return  (BigDecimal) decimalFormat.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
