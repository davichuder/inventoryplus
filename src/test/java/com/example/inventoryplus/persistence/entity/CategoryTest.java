package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.persistence.PersistenceAssertions;

class CategoryTest {
    @Test
    void hasFields() {
        PersistenceAssertions.assertClassHasFields(Category.class,
                Map.of(
                        "id", Long.class,
                        "name", String.class,
                        "description", String.class));
    }
}
