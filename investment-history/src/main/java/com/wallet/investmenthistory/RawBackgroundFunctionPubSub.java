package com.wallet.investmenthistory;

import com.google.cloud.functions.Context;
import com.google.cloud.functions.RawBackgroundFunction;
import com.wallet.investmenthistory.domain.RealStateFund;
import com.wallet.investmenthistory.domain.Stock;
import com.wallet.investmenthistory.enums.InvestmentType;
import com.wallet.investmenthistory.service.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Named("job")
@ApplicationScoped
public class RawBackgroundFunctionPubSub implements RawBackgroundFunction {

    private static final Logger LOGGER = LoggerFactory.getLogger(RawBackgroundFunctionPubSub.class);

    final DownloadService downloadService;
    final RealStateFundService realStateFundService;
    final StockService stockService;


    public RawBackgroundFunctionPubSub(DownloadService downloadService,
                                       RealStateFundService realStateFundService,
                                       StockService stockService) {
        this.downloadService = downloadService;
        this.realStateFundService = realStateFundService;
        this.stockService = stockService;
    }

    @Override
    public void accept(String event, Context context) throws Exception {
        var stockCSV = downloadService.dowload(InvestmentType.STOCK.getType());
        var realStateFundCSV = downloadService.dowload(InvestmentType.FII.getType());
        var stockReader = new StockReader();
        var realStateFundReader = new RealStateFundReader();
        LOGGER.info("stockCSV {}", stockCSV);
        LOGGER.info("realStateFundCSV {}", realStateFundCSV);
        List<Stock> stockList = stockReader.toList(stockCSV);
        LOGGER.info("stockList {}", stockList);
        stockService.persist(stockList);
        List<RealStateFund> realStateFundList = realStateFundReader.toList(realStateFundCSV);
        LOGGER.info("realStateFundList {}", realStateFundList);
        realStateFundService.persist(realStateFundList);
        LOGGER.info("Job executado com sucesso");
    }
}
