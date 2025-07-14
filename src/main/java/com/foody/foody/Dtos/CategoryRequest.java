package com.foody.foody.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class CategoryRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Image is required")
    private MultipartFile image;


    public CategoryRequest(String name, MultipartFile image) {
        this.name = name;
        this.image = image;
    }

    public CategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
