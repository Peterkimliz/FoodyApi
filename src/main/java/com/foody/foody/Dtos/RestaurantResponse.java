package com.foody.foody.Dtos;

import com.foody.foody.Models.Category;

import java.time.LocalDateTime;

public class RestaurantResponse {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private Category category;
    private UserResponse user;
    private String address;
    private String imageUrl;
    private LocalDateTime createdAt;
    private double distance;

    public RestaurantResponse(Long id, String name, double latitude, double longitude, Category category,
                              UserResponse user, String address, String imageUrl, LocalDateTime createdAt,
                              double distance) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
        this.user = user;
        this.address = address;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.distance = distance;
    }

    public RestaurantResponse() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
