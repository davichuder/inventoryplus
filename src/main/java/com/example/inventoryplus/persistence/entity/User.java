package com.example.inventoryplus.persistence.entity;

import com.example.inventoryplus.persistence.enums.RoleEnum;

import lombok.Data;

@Data
public class User {
    
    private Long id;
    private String username;
    private String password;
    private RoleEnum role;
    private Boolean active;
}
