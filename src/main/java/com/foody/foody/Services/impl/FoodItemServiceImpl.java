package com.foody.foody.Services.impl;
import com.foody.foody.Dtos.*;
import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.FoodItem;
import com.foody.foody.Models.RestaurantModel;
import com.foody.foody.Repositories.FoodItemRepository;
import com.foody.foody.Repositories.RestaurantRepository;
import com.foody.foody.Services.interfaces.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Value("${server.host}")
    String host;

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public ApiResponse<FoodItemResponse> createFoodItem(FoodItemRequest foodItemRequest) {
        Optional<RestaurantModel> restaurantModelOptional = restaurantRepository.findById(foodItemRequest.getRestaurantId());
        if (restaurantModelOptional.isEmpty()) {
            throw new NotFoundException("Restaurant with the id not found");
        }

        String path = fileStorageService.storeFile(foodItemRequest.getImage());
        FoodItem foodItem = new FoodItem();
        foodItem.setCreatedAt(LocalDateTime.now());
        foodItem.setName(foodItemRequest.getName());
        foodItem.setDescription(foodItemRequest.getDescription());
        foodItem.setPrice(foodItemRequest.getPrice());
        foodItem.setImageUrl(path);
        foodItem.setRestaurant(restaurantModelOptional.get());
        foodItemRepository.save(foodItem);

        return new ApiResponse<>(constructFoodItemResponse(foodItem));
    }

    @Override
    public ApiResponse<FoodItemResponse> getFoodItemById(Long id) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(id);
        if (optionalFoodItem.isEmpty()) {
            throw new NotFoundException("Food Item Not found");
        }
        return new ApiResponse<>(constructFoodItemResponse(optionalFoodItem.get()));
    }

    private FoodItemResponse constructFoodItemResponse(FoodItem foodItem) {
        FoodItemResponse foodItemResponse = new FoodItemResponse();
        foodItemResponse.setId(foodItem.getId());
        foodItemResponse.setName(foodItem.getName());
        foodItemResponse.setDescription(foodItem.getDescription());
        foodItemResponse.setPrice(foodItem.getPrice());
        foodItemResponse.setCreatedAt(foodItem.getCreatedAt());
        foodItemResponse.setImageUrl(host + "/" + foodItem.getImageUrl());
        foodItemResponse.setRestaurantId(foodItem.getRestaurant().getId());
        return foodItemResponse;

    }

    @Override
    public ApiResponse<List<FoodItemResponse>> getFoodItemByRestaurant(Long id) {
        List<FoodItem> foodItems = foodItemRepository.findByRestaurantId(id);

        List<FoodItemResponse> foodItemResponses = foodItems.stream().map(this::constructFoodItemResponse).toList();
        return new ApiResponse<>(
                foodItemResponses
        );
    }

    @Override
    public void deleteFoodItem(Long id) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(id);
        if (optionalFoodItem.isEmpty()) {
            throw new NotFoundException("Food Item Not found");
        }
        foodItemRepository.delete(optionalFoodItem.get());

    }
}
