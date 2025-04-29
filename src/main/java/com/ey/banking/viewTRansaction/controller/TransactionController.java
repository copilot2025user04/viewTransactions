package com.ey.banking.viewTRansaction.controller;

import com.ey.banking.viewTRansaction.dto.Response;
import com.ey.banking.viewTRansaction.dto.TransactionResponse;
import com.ey.banking.viewTRansaction.entity.Transaction;
import com.ey.banking.viewTRansaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    @PostMapping("/initiate")
    public Mono<Response> createTransaction(@RequestBody Transaction transaction) {
       System.out.println("received request"+transaction );
        return transactionService.createTransaction(transaction);
    }
}
