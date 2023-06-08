package com.blog.apis.controller;

import com.blog.apis.dto.CategoryDto;
import com.blog.apis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategoryDto = categoryService.createCategory(categoryDto);
        return  new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }
    //update
    //get
    //delete
    //getAll
}
