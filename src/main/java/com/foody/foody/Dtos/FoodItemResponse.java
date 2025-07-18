package com.foody.foody.Dtos;
import java.time.LocalDateTime;
public class FoodItemResponse {
    Long id;
    LocalDateTime createdAt;
    String description;
    String imageUrl;
    String name;
    double price;
    Long restaurantId;

    public FoodItemResponse(Long id, LocalDateTime
                                    createdAt, String description, String imageUrl,
                            String name, double price, Long restaurantId) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public FoodItemResponse() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}


