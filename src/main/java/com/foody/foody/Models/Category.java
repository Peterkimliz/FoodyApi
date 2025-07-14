package com.foody.foody.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RestaurantModel> restaurant;

    public Category(Long id, String name, LocalDateTime createdAt,
                    String imageUrl,
                    List<RestaurantModel> restaurant) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.restaurant = restaurant;
    }

    public Category() {
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

    public List<RestaurantModel> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<RestaurantModel> restaurant) {
        this.restaurant = restaurant;
    }
}
