package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.Test;

import com.example.inventoryplus.CustomAssertions;

public class CategoryTest {
    @Test
    public void hasFields() {
        CustomAssertions.assertClassHasFields(Category.class,
                Map.of(
                        "id", Long.class,
                        "name", String.class,
                        "description", String.class));
    }
}
