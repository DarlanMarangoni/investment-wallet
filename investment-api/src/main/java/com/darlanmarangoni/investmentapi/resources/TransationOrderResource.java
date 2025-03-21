package com.darlanmarangoni.investmentapi.resources;

import com.darlanmarangoni.investmentapi.domain.TransactionOrder;
import com.darlanmarangoni.investmentapi.records.BrockerageNoteRecord;
import com.darlanmarangoni.investmentapi.repositories.TransactionRepository;
import com.darlanmarangoni.investmentapi.service.TransationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brockerage-note")
@CrossOrigin("*")
public class TransationOrderResource {

    private final TransactionRepository transactionRepository;

    public TransationOrderResource(TransactionRepository transactionRepository,
                                   TransationService transationService) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/variable-income")
    public ResponseEntity<Object> createNote(@RequestBody BrockerageNoteRecord brockerageNoteRecord) {
        transactionRepository.saveAll(TransactionOrder.from(brockerageNoteRecord));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
