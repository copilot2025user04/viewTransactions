package com.ey.banking.viewTRansaction.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table("transaction")
public class Transaction {
    @Id
    private String transactionId;
    private String senderAccount;
    private String receiverAccount;
    private BigDecimal amount;
    private String currency;
    private String status;
    private LocalDateTime timestamp;
}
