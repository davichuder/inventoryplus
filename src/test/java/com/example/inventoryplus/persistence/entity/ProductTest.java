package com.example.inventoryplus.persistence.entity;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.Test;

import com.example.inventoryplus.CustomAssertions;

public class ProductTest {
    
    @Test
    public void hasFields() {
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
