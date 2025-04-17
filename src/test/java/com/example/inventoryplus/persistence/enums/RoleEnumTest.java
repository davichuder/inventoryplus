package com.example.inventoryplus.persistence.enums;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;

class RoleEnumTest {
    @Test
    void hasValues(){
        CustomAssertions.assertEnumHasValues(RoleEnum.class,
        Set.of("ADMIN", "USER", "MANAGER"));
    }
}
