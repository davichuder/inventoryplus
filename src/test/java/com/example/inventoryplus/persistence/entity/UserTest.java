package com.example.inventoryplus.persistence.entity;

import java.util.Map;

import org.junit.Test;

import com.example.inventoryplus.CustomAssertions;
import com.example.inventoryplus.persistence.enums.RoleEnum;

public class UserTest {
    
    @Test
    public void hasFields() {
        CustomAssertions.assertClassHasFields(User.class,
                Map.of(
                        "id", Long.class,
                        "username", String.class,
                        "password", String.class,
                        "role", RoleEnum.class,
                        "active", Boolean.class));
    }
}
