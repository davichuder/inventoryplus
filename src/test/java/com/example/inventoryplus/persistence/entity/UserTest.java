package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.CustomAssertions;
import com.example.inventoryplus.persistence.enums.RoleEnum;

class UserTest {
    
    @Test
    void hasFields() {
        CustomAssertions.assertClassHasFields(User.class,
                Map.of(
                        "id", Long.class,
                        "username", String.class,
                        "password", String.class,
                        "role", RoleEnum.class,
                        "active", Boolean.class));
    }
}
