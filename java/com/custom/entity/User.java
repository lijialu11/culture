package com.custom.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String role; // "user"或"admin"
}