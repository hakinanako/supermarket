package org.hakiko.supermarket.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction {
    private int transactionID;
    private BigDecimal totalAmount;
    private LocalDateTime transactionDate;
    private BigDecimal balance;
    private int employeeID;
    private String remark;
    private boolean isDeleted;

}