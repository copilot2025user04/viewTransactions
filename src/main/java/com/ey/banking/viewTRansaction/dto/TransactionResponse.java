package com.ey.banking.viewTRansaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TransactionResponse {
    private String transactionId;
    private String senderAccount;
    private String receiverAccount;
    private BigDecimal amount;
    private String status;
    private String transactionCategory;
}
