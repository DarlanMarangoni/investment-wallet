package com.wallet.investment.tasks;

import com.opencsv.exceptions.CsvValidationException;
import com.wallet.investment.enums.InvestmentType;
import com.wallet.investment.reader.RealStateFundReader;
import com.wallet.investment.reader.StockReader;
import com.wallet.investment.service.DownloadService;
import com.wallet.investment.service.RealStateFundService;
import com.wallet.investment.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Slf4j
@Component
public class ScheduledTasks {

    final DownloadService downloadService;
    final RealStateFundService realStateFundService;
    final StockService stockService;

    public ScheduledTasks(DownloadService downloadService,
                          RealStateFundService realStateFundService,
                          StockService stockService) {
        this.downloadService = downloadService;
        this.realStateFundService = realStateFundService;
        this.stockService = stockService;
    }

    @Scheduled(cron = "0 0 10 * * ?")
    public void reportCurrentTime() throws IOException, InterruptedException, CsvValidationException {
        log.info("Task started at {}", LocalDateTime.now());
        var realStateFundCSV = downloadService.dowload(InvestmentType.FII.getType());
        var stockCSV = downloadService.dowload(InvestmentType.STOCK.getType());
        realStateFundService.saveAll(new RealStateFundReader().toList(realStateFundCSV));
        stockService.saveAll(new StockReader().toList(stockCSV));
        log.info("Task finished at {}", LocalDateTime.now());
    }
}
