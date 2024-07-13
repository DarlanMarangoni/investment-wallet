package com.wallet.investmenthistory;

import com.wallet.investmenthistory.domain.RealStateFund;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RealStateFundRepository implements PanacheRepository<RealStateFund> {}
