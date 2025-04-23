package com.example.inventoryplus.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.persistence.PersistenceAssertions;
import com.example.inventoryplus.persistence.enums.StatusEnum;

class SaleTest {
    
    @Test
    void hasFields() {
        PersistenceAssertions.assertClassHasFields(Sale.class,
                Map.of(
                        "id", Long.class,
                        "customer", Customer.class,
                        "total", BigDecimal.class,
                        "date", LocalDateTime.class,
                        "user", User.class,
                        "status", StatusEnum.class));
    }
}
