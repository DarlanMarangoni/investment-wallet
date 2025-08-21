package com.darlanmarangoni.investmentapi.resources;

import com.darlanmarangoni.investmentapi.domain.Investment;
import com.darlanmarangoni.investmentapi.repositories.InvestmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investments")
public class InvestmentResource {

    private final InvestmentRepository investmentRepository;

    public InvestmentResource(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @GetMapping
    public Page<Investment> findAll(Pageable pageable) {
        return investmentRepository.findAll(pageable);
    }

    @PostMapping
    public Investment save(@RequestBody Investment investment) {
        return investmentRepository.save(investment);
    }

}
