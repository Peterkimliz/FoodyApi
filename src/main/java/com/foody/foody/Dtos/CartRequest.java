package com.foody.foody.Dtos;

public class CartRequest {

    private Long userId;
    private Long foodItemId;
    private int quantity;

    public CartRequest(Long userId, Long foodItemId, int quantity) {
        this.userId = userId;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
    }

    public CartRequest() {
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}