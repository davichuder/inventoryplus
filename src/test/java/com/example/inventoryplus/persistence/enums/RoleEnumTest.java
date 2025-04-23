package com.example.inventoryplus.persistence.enums;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.persistence.PersistenceAssertions;

class RoleEnumTest {
    @Test
    void hasValues(){
        PersistenceAssertions.assertEnumHasValues(RoleEnum.class,
        Set.of("ADMIN", "USER", "MANAGER"));
    }
}
