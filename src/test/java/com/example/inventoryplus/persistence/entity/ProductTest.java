package com.example.inventoryplus.persistence.entity;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;

class ProductTest {
    
    @Test
    void hasFields() {
        CustomAssertions.assertClassHasFields(Product.class,
                Map.of(
                        "id", Long.class,
                        "name", String.class,
                        "description", String.class,
                        "price", Double.class,
                        "stock", Integer.class,
                        "category", Category.class,
                        "createdAt", LocalDateTime.class));
    }
}
