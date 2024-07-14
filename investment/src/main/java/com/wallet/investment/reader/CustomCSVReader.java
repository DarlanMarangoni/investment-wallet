package com.wallet.investment.reader;


import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public interface CustomCSVReader<T> {
    T toList(String csv) throws CsvValidationException, IOException;
}
