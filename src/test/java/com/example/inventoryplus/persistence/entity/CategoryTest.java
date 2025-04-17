package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;

class CategoryTest {
    @Test
    void hasFields() {
        CustomAssertions.assertClassHasFields(Category.class,
                Map.of(
                        "id", Long.class,
                        "name", String.class,
                        "description", String.class));
    }
}
