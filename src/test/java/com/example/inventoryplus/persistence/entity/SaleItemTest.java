package com.example.inventoryplus.persistence.entity;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

import com.example.inventoryplus.CustomAssertions;

public class SaleItemTest {

    @Test
    public void hasFields() {
        CustomAssertions.assertClassHasFields(SaleItem.class, 
                Map.of(
                        "id", Long.class,
                        "sale", Sale.class,
                        "product", Product.class,
                        "quantity", Integer.class,
                        "price", BigDecimal.class));
    }
}
