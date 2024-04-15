package org.hakiko.supermarket.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private int orderID;
    private int transactionID;
    private int employeeID;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private String remark;
    private boolean isDeleted;
}