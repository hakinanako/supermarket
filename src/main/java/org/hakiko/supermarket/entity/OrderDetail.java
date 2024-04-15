package org.hakiko.supermarket.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private int orderDetailID;
    private int orderID;
    private int skuID;
    private int quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
    private String remark;
    private boolean isDeleted;

    // getters and setters...
    // ...
}