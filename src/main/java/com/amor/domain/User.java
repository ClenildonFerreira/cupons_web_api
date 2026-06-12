package com.amor.domain;

import lombok.Getter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class User {
    private UUID id;
    private String username;
    private String password;
    private UserRole role;
    private String partnerName;
    private LocalDate startDate;

    public User(String username, String password, UserRole role) {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("Username is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");
        if (role == null) throw new IllegalArgumentException("Role is required");
        
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setRelationshipInfo(String partnerName, LocalDate startDate) {
        this.partnerName = partnerName;
        this.startDate = startDate;
    }
}
