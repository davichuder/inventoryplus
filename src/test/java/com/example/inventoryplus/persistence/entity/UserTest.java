package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.inventoryplus.persistence.PersistenceAssertions;
import com.example.inventoryplus.persistence.enums.RoleEnum;

class UserTest {
    
    @Test
    void hasFields() {
        PersistenceAssertions.assertClassHasFields(User.class,
                Map.of(
                        "id", Long.class,
                        "username", String.class,
                        "password", String.class,
                        "role", RoleEnum.class,
                        "active", Boolean.class));
    }
}
