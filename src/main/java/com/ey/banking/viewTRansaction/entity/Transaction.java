package com.ey.banking.viewTRansaction.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@ToString
@Table("transaction")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Transaction {
    @Id
    private String transactionId;
    private String senderAccount;
    private String receiverAccount;
    private Integer amount;
    private String currency;
    private String status;
    private LocalDateTime timestamp;
}
