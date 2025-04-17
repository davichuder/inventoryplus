package com.example.inventoryplus.persistence.enums;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;

 class StatusEnumTest {

    @Test
     void hasValues() {
        CustomAssertions.assertEnumHasValues(StatusEnum.class,
                Set.of("RESERVED", "AVAILABLE", "SOLD", "PAID", "CANCELLED"));
    }
}
