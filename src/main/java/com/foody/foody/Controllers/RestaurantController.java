package com.foody.foody.Controllers;

import com.foody.foody.Dtos.*;
import com.foody.foody.Models.RestaurantModel;
import com.foody.foody.Services.interfaces.RestaurantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Restaurant")
@RestController
@RequestMapping("/api/v1/restaurant/")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @PostMapping(value = "create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<RestaurantResponse>> createCategory(
            @ModelAttribute @Validated RestaurantRequest restaurantRequest
    ) {
        System.out.println("Called");
        return new ResponseEntity<>(restaurantService.createRestaurant(restaurantRequest), HttpStatus.CREATED);
    }


    @GetMapping("all")
    public ResponseEntity<ApiResponse<List<RestaurantResponse>>> getRestaurants(
            @RequestParam(value = "latitude") double latitude,
            @RequestParam(value = "longitude") double longitude
    ) {
        return new ResponseEntity<>(restaurantService.getRestaurantByLatitudeAndLongitude(latitude, longitude), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<String>("Restaurant Deleted", HttpStatus.CREATED);
    }

}
