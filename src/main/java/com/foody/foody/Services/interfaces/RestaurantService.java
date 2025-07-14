package com.foody.foody.Services.interfaces;

import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.RestaurantRequest;
import com.foody.foody.Dtos.RestaurantResponse;
import com.foody.foody.Models.RestaurantModel;

import java.util.List;

public interface RestaurantService {

     ApiResponse<RestaurantResponse> getRestaurantById(Long id);
    ApiResponse< RestaurantResponse >createRestaurant(RestaurantRequest restaurantRequest);
    ApiResponse< List<RestaurantResponse>> getRestaurantByLatitudeAndLongitude(double latitude, double longitude);
     void deleteRestaurant(Long id);


}
