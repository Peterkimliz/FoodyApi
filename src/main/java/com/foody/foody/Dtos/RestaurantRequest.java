package com.foody.foody.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class RestaurantRequest {
    @NotBlank(message = "name is required")
    private String name;

    private double latitude;

    private double longitude;
    @Min(value = 1,message = "category is required")
    private Long category;
    @Min(value = 1, message = "user is required")
    private Long user;
    @NotBlank(message = "address is required")
    private String address;
    @NotNull(message = "image is required")
    private MultipartFile image;

    public RestaurantRequest(String name, double latitude, double longitude,
                             Long category,
                             Long user, String address, MultipartFile image) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
        this.user = user;
        this.address = address;
        this.image = image;
    }

    public RestaurantRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
