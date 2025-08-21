package com.darlanmarangoni.investmentapi.resources;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investments")
public class InvestmentResource {

    @GetMapping
    public Object findAll(Pageable pageable) {
        return "listagem dos investimentos";
    }

}
