package com.darlanmarangoni.investmentapi.earning.resource;

import com.darlanmarangoni.investmentapi.earning.domain.Earning;
import com.darlanmarangoni.investmentapi.earning.dto.EarningDto;
import com.darlanmarangoni.investmentapi.earning.repository.EarningRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/earnings")
public class EarningResource {

    public static final UUID USER_ID = UUID.fromString("a233a502-5a2e-4232-bd02-e1969942b58f");
    private final EarningRepository earningRepository;

    public EarningResource(EarningRepository earningRepository) {
        this.earningRepository = earningRepository;
    }

    @GetMapping
    public Page<Earning> findAll(Pageable pageable) {
        return earningRepository.findByUserId(USER_ID, pageable);
    }

    @PostMapping
    public Earning save(@RequestBody EarningDto dto) {
        Earning earning = Earning.from(dto);
        earning.setUserId(USER_ID);
        return earningRepository.save(earning);
    }
}
