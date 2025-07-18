package com.foody.foody.Controllers;

import com.foody.foody.Dtos.*;
import com.foody.foody.Services.interfaces.FoodItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "FoodItem")
@RestController
@RequestMapping("/api/v1/foodItem/")
public class FoodItemController {
    @Autowired
     FoodItemService foodItemService;

    @PostMapping(value = "create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<ApiResponse<FoodItemResponse>> createFoodItem(@ModelAttribute @Validated FoodItemRequest foodItemRequest) {
        return new ResponseEntity<>(foodItemService.createFoodItem(foodItemRequest), HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    ResponseEntity<ApiResponse<FoodItemResponse>> getFoodItemById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(foodItemService.getFoodItemById(id), HttpStatus.OK);
    }

    @GetMapping("all/{restaurantId}")
    ResponseEntity<ApiResponse<List<FoodItemResponse>>> getFoodItemByRestaurant(@PathVariable("restaurantId") Long id) {
        return new ResponseEntity<>(foodItemService.getFoodItemByRestaurant(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteFoodItem(@PathVariable("id") Long id) {
        foodItemService.deleteFoodItem(id);
        return new ResponseEntity<>(new ApiResponse<>("Restaurant deleted"), HttpStatus.OK);


    }


}
