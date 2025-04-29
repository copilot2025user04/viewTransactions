package com.ey.banking.viewTRansaction.service;

import com.ey.banking.viewTRansaction.dto.Response;
import com.ey.banking.viewTRansaction.dto.TransactionResponse;
import com.ey.banking.viewTRansaction.entity.Transaction;
import com.ey.banking.viewTRansaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    @Autowired
    private R2dbcEntityTemplate r2dbcEntityTemplate;
    @Autowired
    private final TransactionRepository transactionRepository;

    public Flux<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll()
                .map(txn -> new TransactionResponse(
                        txn.getTransactionId(),
                        txn.getSenderAccount(),
                        txn.getReceiverAccount(),
                        txn.getAmount(),
                        txn.getStatus(),
                        null
                ));
    }

    public Flux<TransactionResponse> getAllTransactions(String accountId) {
        return transactionRepository.findAll().filter(tran -> tran.getSenderAccount().equals(accountId)
                        || tran.getReceiverAccount().equals(accountId))
                .map(txn -> new TransactionResponse(
                        txn.getTransactionId(),
                        txn.getSenderAccount(),
                        txn.getReceiverAccount(),
                        txn.getAmount(),
                        txn.getStatus(),
                        txn.getSenderAccount().equals(accountId) ? "Debit" : "Credit"
                ));
    }

    public Mono<Response> createTransaction(Transaction transaction) {
        if (transaction.getTransactionId() == null || transaction.getTransactionId().isEmpty()) {
            transaction.setTransactionId(UUID.randomUUID().toString());
        }
        transaction.setStatus("SUCCESS");

       return r2dbcEntityTemplate.insert(Transaction.class)
    .using(transaction)
    .thenReturn(new Response("success"))
    .onErrorResume(ex -> {
     System.out.println("Error occurred"+ex);
        return Mono.just(new Response("failure"));
    });
    }
}
