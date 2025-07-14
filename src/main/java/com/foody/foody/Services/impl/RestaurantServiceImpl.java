package com.foody.foody.Services.impl;

import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.RestaurantRequest;
import com.foody.foody.Dtos.RestaurantResponse;
import com.foody.foody.Exceptions.FoundException;
import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.RestaurantModel;
import com.foody.foody.Repositories.RestaurantRepository;
import com.foody.foody.Services.interfaces.CategoryService;
import com.foody.foody.Services.interfaces.RestaurantService;
import com.foody.foody.Services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;
    @Value("${server.host}")
    String host;


    @Override
    public ApiResponse<RestaurantResponse> createRestaurant(RestaurantRequest restaurantRequest) {
        Optional<RestaurantModel> restaurantModelOptional = restaurantRepository.
                findByNameAndUserId(restaurantRequest.getName(), restaurantRequest.getUser());

        if (restaurantModelOptional.isPresent()) {
            throw new FoundException("restaurant with the name already exists");

        }
        String path = fileStorageService.storeFile(restaurantRequest.getImage());
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setCreatedAt(LocalDateTime.now());
        restaurantModel.setAddress(restaurantRequest.getAddress());
        restaurantModel.setImageUrl(path);
        restaurantModel.setName(restaurantRequest.getName());
        restaurantModel.setLatitude(restaurantRequest.getLatitude());
        restaurantModel.setLongitude(restaurantRequest.getLongitude());
        restaurantModel.setCategory(categoryService.getCategory(restaurantRequest.getCategory()));
        restaurantModel.setUser(userService.getUserById(restaurantRequest.getUser()));
        restaurantRepository.save(restaurantModel);
        return new ApiResponse<>(constructRestaurantResponse(restaurantModel));
    }

    private RestaurantResponse constructRestaurantResponse(RestaurantModel restaurantModel) {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantResponse.setAddress(restaurantModel.getAddress());
        restaurantResponse.setCategory(restaurantModel.getCategory());
        restaurantResponse.setUser(restaurantModel.getUser());
        restaurantResponse.setId(restaurantModel.getId());
        restaurantResponse.setName(restaurantModel.getName());
        restaurantResponse.setLatitude(restaurantModel.getLatitude());
        restaurantResponse.setLongitude(restaurantModel.getLongitude());
        restaurantResponse.setDistance(restaurantModel.getDistance());
        restaurantResponse.setCreatedAt(restaurantModel.getCreatedAt());
        restaurantResponse.setImageUrl(host+"/"+restaurantModel.getImageUrl());

        return restaurantResponse;
    }

    @Override
    public ApiResponse<RestaurantResponse> getRestaurantById(Long id) {
        return new ApiResponse<>(constructRestaurantResponse(getRestaurant(id)));
    }

    private RestaurantModel getRestaurant(Long id) {
        Optional<RestaurantModel> restaurantModelOptional = restaurantRepository.findById(id);

        if (restaurantModelOptional.isEmpty()) {
            throw new NotFoundException("Restaurant not found");
        }
        return restaurantModelOptional.get();
    }


    @Override
    public ApiResponse<List<RestaurantResponse>> getRestaurantByLatitudeAndLongitude(double latitude, double longitude) {
        List<RestaurantModel> restaurantModelList = restaurantRepository.findAll();
        if (restaurantModelList.isEmpty()) {
            return new ApiResponse<>(new ArrayList<>());
        }


        return new ApiResponse<>(restaurantModelList.stream().map(this::constructRestaurantResponse).toList());
    }

    @Override
    public void deleteRestaurant(Long id) {
        RestaurantModel restaurantModel = getRestaurant(id);
        restaurantRepository.deleteById(restaurantModel.getId());

    }
}
