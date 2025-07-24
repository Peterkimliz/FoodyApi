package com.foody.foody.Dtos;
import com.foody.foody.Models.FoodItem;

public class CartItemResponse {
    private Long id;
    private int quantity;
    private FoodItemResponse foodItem;

    public CartItemResponse(Long id,  FoodItemResponse foodItem, Integer quantity) {
        this.id = id;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public CartItemResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public FoodItemResponse getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItemResponse foodItem) {
        this.foodItem = foodItem;
    }
}
