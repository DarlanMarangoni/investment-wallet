package com.wallet.investmenthistory;

import com.google.cloud.functions.Context;
import com.google.cloud.functions.RawBackgroundFunction;
import com.wallet.investmenthistory.enums.InvestmentType;
import com.wallet.investmenthistory.service.DownloadService;
import com.wallet.investmenthistory.service.RealStateFundReader;
import com.wallet.investmenthistory.service.StockReader;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

@Named("job")
@ApplicationScoped
public class RawBackgroundFunctionPubSub implements RawBackgroundFunction {

    final DownloadService downloadService;
    final StockRepository stockRepository;
    final RealStateFundRepository realStateFundRepository;

    public RawBackgroundFunctionPubSub(DownloadService downloadService,
                                       StockRepository stockRepository,
                                       RealStateFundRepository realStateFundRepository) {
        this.downloadService = downloadService;
        this.stockRepository = stockRepository;
        this.realStateFundRepository = realStateFundRepository;
    }

    @Transactional
    @Override
    public void accept(String event, Context context) throws Exception {
        var stockCSV = downloadService.dowload(InvestmentType.STOCK.getType());
        var realStateFundCSV = downloadService.dowload(InvestmentType.FII.getType());
        var stockList = new StockReader().toList(stockCSV);
        var realStateFundList = new RealStateFundReader().toList(realStateFundCSV);
        stockRepository.persist(stockList);
        realStateFundRepository.persist(realStateFundList);
    }
}
