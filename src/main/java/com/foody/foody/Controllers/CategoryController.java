package com.foody.foody.Controllers;

import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.CategoryRequest;
import com.foody.foody.Dtos.CategoryResponse;
import com.foody.foody.Services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
     CategoryService categoryService;


    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CategoryResponse>>>getCategories(){
        return  new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }


    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<CategoryResponse>>createCategory(@ModelAttribute @Validated  CategoryRequest categoryRequest){
        System.out.println("Called");
        return new ResponseEntity<>(categoryService.createCategory(categoryRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return  new ResponseEntity<String>("Category Deleted", HttpStatus.CREATED);
    }


}
