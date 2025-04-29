package com.ey.banking.viewTRansaction.controller;

import com.ey.banking.viewTRansaction.dto.TransactionResponse;
import com.ey.banking.viewTRansaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public Flux<TransactionResponse> getTransactions() {

        return transactionService.getAllTransactions();
    }
    @GetMapping("/{accountId}")
    public Flux<TransactionResponse> getTransactionsByAcctId(@PathVariable String accountId) {
        return transactionService.getAllTransactions(accountId);
    }
}
