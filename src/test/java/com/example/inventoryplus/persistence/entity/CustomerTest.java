package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;

public class CustomerTest {

    @Test
    public void hasFields() {
        CustomAssertions.assertClassHasFields(Customer.class,
                Map.of(
                        "id", Long.class,
                        "name", String.class,
                        "email", String.class,
                        "phone", String.class,
                        "address", String.class));
    }
}
