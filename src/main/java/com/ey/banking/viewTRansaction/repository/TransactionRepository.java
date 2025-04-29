package com.ey.banking.viewTRansaction.repository;

import com.ey.banking.viewTRansaction.entity.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, String> {
    // Custom queries can be added here if needed

}
