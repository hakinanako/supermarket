package org.hakiko.supermarket.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SKU {
    private int skuID;
    private int spuID;
    private String skuName;
    private String attributes;
    private BigDecimal price;
    private int stockQuantity;
    private String imageURL;
    private String remark;
    private boolean isDeleted;
}