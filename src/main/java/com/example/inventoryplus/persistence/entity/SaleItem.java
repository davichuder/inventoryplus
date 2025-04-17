package com.example.inventoryplus.persistence.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItem {
 
    private Long id;
    private Sale sale;
    private Product product;
    private Integer quantity;
    private BigDecimal price;
}
