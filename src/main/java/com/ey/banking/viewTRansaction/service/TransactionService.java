package com.ey.banking.viewTRansaction.service;

import com.ey.banking.viewTRansaction.dto.TransactionResponse;
import com.ey.banking.viewTRansaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TransactionService {
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
        return transactionRepository.findAll().filter(tran->tran.getSenderAccount().equals(accountId)
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
}
