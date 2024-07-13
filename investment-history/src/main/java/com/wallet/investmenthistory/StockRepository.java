package com.wallet.investmenthistory;

import com.wallet.investmenthistory.domain.Stock;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockRepository implements PanacheRepository<Stock> {}
