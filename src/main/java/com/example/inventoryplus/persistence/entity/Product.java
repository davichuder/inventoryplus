package com.example.inventoryplus.persistence.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Product {
    
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Category category;
    private LocalDateTime createdAt;
}
