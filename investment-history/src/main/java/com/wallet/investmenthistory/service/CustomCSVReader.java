package com.wallet.investmenthistory.service;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public interface CustomCSVReader<T> {
    T toList(String csv) throws CsvValidationException, IOException;
}
