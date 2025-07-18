package com.foody.foody.Services.impl;


import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.CategoryRequest;
import com.foody.foody.Dtos.CategoryResponse;
import com.foody.foody.Exceptions.FoundException;
import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.Category;
import com.foody.foody.Repositories.CategoryRepository;
import com.foody.foody.Services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${server.host}")
    String host;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    FileStorageService fileStorageService;

    @Override
    public ApiResponse<CategoryResponse> createCategory(CategoryRequest categoryRequest) {
        Optional<Category> foundCategory = categoryRepository.findByName(categoryRequest.getName().toLowerCase());
        System.out.println("TTT");
        if (foundCategory.isPresent()) {
            throw new FoundException("Category With that name already exists");
        }
        System.out.println("TTT");
        String filePath = fileStorageService.storeFile(categoryRequest.getImage());
        Category category = new Category();
        category.setCreatedAt(LocalDateTime.now());
        category.setName(categoryRequest.getName().toLowerCase());
        category.setImageUrl(filePath);
        categoryRepository.save(category);

        return new  ApiResponse<>(constructCategoryResponse(category));
    }

    private CategoryResponse constructCategoryResponse(Category category) {

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCreatedAt(category.getCreatedAt());
        categoryResponse.setName(category.getName());
        categoryResponse.setId(category.getId());
        categoryResponse.setImageUrl(host+"/"+category.getImageUrl());
        return categoryResponse;
    }

    @Override
    public ApiResponse<List<CategoryResponse>> getCategories() {
        List<Category> categories=categoryRepository.findAll();
        if (categories.isEmpty()){
            return new ApiResponse<>(
                    new ArrayList<>()
            );
        }
        return new ApiResponse<>(categories.stream().map(this::constructCategoryResponse).toList());

    }


    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public Category getCategory(Long category) {
        Optional<Category> categoryOptional=categoryRepository.findById(category);

        if(categoryOptional.isEmpty()){
            throw  new NotFoundException("Category not found");
        }

        return categoryOptional.get();
    }
}
