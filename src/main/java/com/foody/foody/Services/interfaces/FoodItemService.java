package com.foody.foody.Services.interfaces;
import com.foody.foody.Dtos.*;
import java.util.List;
public interface FoodItemService {
    ApiResponse<FoodItemResponse> createFoodItem(FoodItemRequest foodItemRequest);
    ApiResponse<FoodItemResponse>getFoodItemById(Long id );
    ApiResponse<List<FoodItemResponse>>getFoodItemByRestaurant(Long id);
    void deleteFoodItem(Long id);
}
