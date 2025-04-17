package com.example.inventoryplus.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.junit.Test;

import com.example.inventoryplus.CustomAssertions;
import com.example.inventoryplus.persistence.enums.StatusEnum;

public class SaleTest {
    
    @Test
    public void hasFields() {
        CustomAssertions.assertClassHasFields(Sale.class,
                Map.of(
                        "id", Long.class,
                        "customer", Customer.class,
                        "total", BigDecimal.class,
                        "date", LocalDateTime.class,
                        "user", User.class,
                        "status", StatusEnum.class));
    }
}
