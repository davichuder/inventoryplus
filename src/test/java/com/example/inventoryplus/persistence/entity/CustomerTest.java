package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.persistence.PersistenceAssertions;

class CustomerTest {

    @Test
    void hasFields() {
        PersistenceAssertions.assertClassHasFields(Customer.class,
                Map.of(
                        "id", Long.class,
                        "name", String.class,
                        "email", String.class,
                        "phone", String.class,
                        "address", String.class));
    }
}
