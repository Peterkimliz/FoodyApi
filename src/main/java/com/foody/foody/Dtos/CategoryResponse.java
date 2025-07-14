package com.foody.foody.Dtos;

import java.time.LocalDateTime;

public class CategoryResponse {
    private String name;
    private Long id;
    private LocalDateTime createdAt;
    private  String imageUrl;

    public CategoryResponse(String name, Long id, LocalDateTime createdAt, String imageUrl) {
        this.name = name;
        this.id = id;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
    }

    public CategoryResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
