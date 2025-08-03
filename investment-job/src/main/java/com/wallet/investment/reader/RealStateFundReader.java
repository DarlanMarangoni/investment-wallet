package com.wallet.investment.reader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.wallet.investment.domain.RealStateFund;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class RealStateFundReader implements CustomCSVReader<List<RealStateFund>> {
    @Override
    public List<RealStateFund> toList(String csv) throws CsvValidationException, IOException {
        try (CSVReader reader = new CSVReaderBuilder(new StringReader(csv))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build()) {
            reader.skip(1);
            String[] nextLine;
            var data = new ArrayList<RealStateFund>();
            while ((nextLine = reader.readNext()) != null) {
                data.add(new RealStateFund(nextLine));
            }
            return data;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
