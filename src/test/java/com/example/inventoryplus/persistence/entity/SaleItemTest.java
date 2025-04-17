package com.example.inventoryplus.persistence.entity;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;

class SaleItemTest {

    @Test
    void hasFields() {
        CustomAssertions.assertClassHasFields(SaleItem.class, 
                Map.of(
                        "id", Long.class,
                        "sale", Sale.class,
                        "product", Product.class,
                        "quantity", Integer.class,
                        "price", BigDecimal.class));
    }
}
