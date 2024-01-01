package org.example.entity;

import jakarta.persistence.Entity;

@Entity
public class User {
    protected Long id;

    public Long getId() {
        return id;
    }

    protected String username;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
