package com.example.inventoryplus.persistence.enums;

import java.util.Set;

import org.junit.Test;

import com.example.inventoryplus.CustomAssertions;

public class RoleEnumTest {
    @Test
    public void hasValues(){
        CustomAssertions.assertEnumHasValues(RoleEnum.class,
        Set.of("ADMIN", "USER", "MANAGER"));
    }
}
