package com.foody.foody.Dtos;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class FoodItemRequest {
    @NotBlank(message = "description is required ")
    String description;
    @NotNull(message = "image is required ")
    MultipartFile image;
    @NotBlank(message = "name is required ")
    String name;
    @NotNull(message = "price is required")
    @DecimalMin(value = "0.1", inclusive = true, message = "Value must be at least 0.1")
    double price;
    @NotNull(message = "restaurantId is required ")
    Long  restaurantId;

    public FoodItemRequest() {
    }

    public FoodItemRequest(String description, MultipartFile image, String name, double price, Long restaurantId) {
        this.description = description;
        this.image = image;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}


