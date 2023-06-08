package com.blog.apis.service;

import com.blog.apis.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    CategoryDto getCategory(Integer categoryId);
    void deleteCategory(Integer categoryId);
    List<CategoryDto> getAllCategories();
}
