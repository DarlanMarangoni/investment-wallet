package com.wallet.investment.resources;

import com.wallet.investment.domain.TransactionOrder;
import com.wallet.investment.records.BrockerageNoteRecord;
import com.wallet.investment.repositories.TransactionOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brockerage-note")
public class TransationOrderResource {

    final TransactionOrderRepository transactionOrderRepository;

    public TransationOrderResource(TransactionOrderRepository transactionOrderRepository) {
        this.transactionOrderRepository = transactionOrderRepository;
    }

    @PostMapping("/variable-income")
    public ResponseEntity<Object> createNote(@RequestBody BrockerageNoteRecord brockerageNoteRecord) {
        transactionOrderRepository.saveAll(TransactionOrder.from(brockerageNoteRecord));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
