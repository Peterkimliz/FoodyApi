package com.foody.foody.Dtos;
import java.time.LocalDateTime;
import java.util.List;

public class CartResponse {
    private Long id;
    private LocalDateTime createdAt;
    private List<CartItemResponse> foodItemList;
    private UserResponse user;


    public CartResponse(Long id, LocalDateTime createdAt,
                        List<CartItemResponse> foodItemList,
                        UserResponse user) {
        this.id = id;
        this.createdAt = createdAt;
        this.foodItemList = foodItemList;
        this.user = user;
    }

    public CartResponse() {
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

    public List<CartItemResponse> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<CartItemResponse> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
