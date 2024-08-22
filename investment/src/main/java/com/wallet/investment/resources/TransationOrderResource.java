package com.wallet.investment.resources;

import com.wallet.investment.domain.TransactionOrder;
import com.wallet.investment.records.BrockerageNoteRecord;
import com.wallet.investment.records.ResumeRecord;
import com.wallet.investment.repositories.TransactionRepository;
import com.wallet.investment.service.RealStateFundService;
import com.wallet.investment.service.StockService;
import com.wallet.investment.service.TransationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brockerage-note")
public class TransationOrderResource {

    private final TransactionRepository transactionRepository;
    private final TransationService transationService;
    private final StockService stockService;
    private final RealStateFundService realStateFundService;

    public TransationOrderResource(TransactionRepository transactionRepository,
                                   TransationService transationService,
                                   StockService stockService,
                                   RealStateFundService realStateFundService) {
        this.transactionRepository = transactionRepository;
        this.transationService = transationService;
        this.stockService = stockService;
        this.realStateFundService = realStateFundService;
    }

    @PostMapping("/variable-income")
    public ResponseEntity<Object> createNote(@RequestBody BrockerageNoteRecord brockerageNoteRecord) {
        transactionRepository.saveAll(TransactionOrder.from(brockerageNoteRecord));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/resume")
    public ResponseEntity<ResumeRecord> calculateInvestedValue() {
        var stockCurrentValue = stockService.currentValue();
        var fiiCurrentValue = realStateFundService.currentValue();
        return ResponseEntity.ok(new ResumeRecord(
                stockCurrentValue.add(fiiCurrentValue),
                transationService.calculateInvestedValue()
        ));
    }

}
