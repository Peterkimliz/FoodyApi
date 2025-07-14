package com.foody.foody.Services.interfaces;

import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.CategoryRequest;
import com.foody.foody.Dtos.CategoryResponse;
import com.foody.foody.Models.Category;

import java.util.List;

public interface CategoryService {

   ApiResponse< List<CategoryResponse>> getCategories();

    ApiResponse<CategoryResponse> createCategory(CategoryRequest categoryRequest);

    void deleteCategory(Long id);

    Category getCategory(Long category);
}
