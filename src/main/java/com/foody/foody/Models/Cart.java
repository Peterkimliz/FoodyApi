package com.foody.foody.Models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cart")
    private List<CartItem> foodItemList;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;


    public Cart(Long id, LocalDateTime createdAt, List<CartItem> foodItemList, UserModel user) {
        this.id = id;
        this.createdAt = createdAt;
        this.foodItemList = foodItemList;
        this.user = user;
    }

    public Cart() {
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

    public List<CartItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<CartItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
