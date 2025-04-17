package com.example.inventoryplus.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.inventoryplus.persistence.enums.StatusEnum;

import lombok.Data;

@Data
public class Sale {
    
    private Long id;
    private Customer customer;
    private BigDecimal total;
    private LocalDateTime date;
    private User user;
    private StatusEnum status;
}
