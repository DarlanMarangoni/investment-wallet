package com.darlanmarangoni.investmentapi.investment.resources;

import com.darlanmarangoni.investmentapi.enums.InvestmentType;
import com.darlanmarangoni.investmentapi.investment.domain.Investment;
import com.darlanmarangoni.investmentapi.investment.dto.InvestmentDto;
import com.darlanmarangoni.investmentapi.investment.repositories.InvestmentRepository;
import com.darlanmarangoni.investmentapi.repositories.RealStateFundRepository;
import com.darlanmarangoni.investmentapi.repositories.StockRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/investments")
public class InvestmentResource {

    public static final UUID USER_ID = UUID.fromString("a233a502-5a2e-4232-bd02-e1969942b58f");
    private final InvestmentRepository investmentRepository;
    private final StockRepository stockRepository;
    private final RealStateFundRepository realStateFundRepository;

    public InvestmentResource(InvestmentRepository investmentRepository,
                              StockRepository stockRepository,
                              RealStateFundRepository realStateFundRepository) {
        this.investmentRepository = investmentRepository;
        this.stockRepository = stockRepository;
        this.realStateFundRepository = realStateFundRepository;
    }

    @GetMapping
    public Page<Investment> findAll(Pageable pageable) {
        return investmentRepository.findByUserId(USER_ID, pageable);
    }

    @PostMapping
    public Investment save(@RequestBody InvestmentDto dto) {
        var investments = investmentRepository.findByTickerAndUserId(dto.ticker(), USER_ID);
        investments.forEach(investment -> investment.setActive(false));
        investmentRepository.saveAll(investments);
        var entity = Investment.from(dto);
        if (entity.getInvestmentType().equals(InvestmentType.STOCK)) {
            stockRepository.findFirstByTickerOrderByDatCreationDesc(dto.ticker()).ifPresent(stock -> {
                entity.setTotal(stock.getPreco().multiply(BigDecimal.valueOf(entity.getAmount())));
            });
        }
        if (entity.getInvestmentType().equals(InvestmentType.FII)) {
            realStateFundRepository.findFirstByTickerOrderByDatCreationDesc(dto.ticker()).ifPresent(fii -> {
                entity.setTotal(fii.getPreco().multiply(BigDecimal.valueOf(entity.getAmount())));
            });
        }
        entity.setUserId(USER_ID);
        return investmentRepository.save(entity);
    }

    @DeleteMapping("/{investmentId}")
    public void delete(@PathVariable UUID investmentId) {
        Optional<Investment> entity = investmentRepository.findById(investmentId);
        if (entity.isPresent()) {
            investmentRepository.delete(entity.get());
            ResponseEntity.noContent().build();
        }
        ResponseEntity.notFound().build();
    }

    @GetMapping("/{investmentId}")
    public ResponseEntity<Object> findById(@PathVariable UUID investmentId) {
        Optional<Investment> entity = investmentRepository.findById(investmentId);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/investmentId")
    public ResponseEntity<Object> updateInvestmentId(@PathVariable UUID investmentId, @RequestBody InvestmentDto dto) {
        Optional<Investment> entity = investmentRepository.findById(investmentId);
        if (entity.isPresent()) {
            BeanUtils.copyProperties(dto, entity.get());
            return ResponseEntity.ok(investmentRepository.save(entity.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
