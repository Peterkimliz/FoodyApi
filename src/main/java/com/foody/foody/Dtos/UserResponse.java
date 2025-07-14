package com.foody.foody.Dtos;

import java.time.LocalDateTime;

public class UserResponse {
    private String fullName;
    private String email;
    private Long id;
    private LocalDateTime createdAt;

    public UserResponse(String fullName, String email, Long id, LocalDateTime createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
