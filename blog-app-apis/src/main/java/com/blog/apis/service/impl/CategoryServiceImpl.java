package com.blog.apis.service.impl;

import com.blog.apis.dto.CategoryDto;
import com.blog.apis.exception.ResourceNotFoundException;
import com.blog.apis.model.Category;
import com.blog.apis.repository.CategoryRepo;
import com.blog.apis.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category addedCategory = categoryRepo.save(category);
        CategoryDto addedCategoryDto = modelMapper.map(addedCategory, CategoryDto.class);
        addedCategoryDto.setCategoryId(addedCategory.getCategoryId());
        return addedCategoryDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        CategoryDto ctg = getCategory(categoryId);
        ctg.setCategoryId(categoryDto.getCategoryId());
        ctg.setCategoryTittle(categoryDto.getCategoryTittle());
        ctg.setCategoryDescription(categoryDto.getCategoryDescription());
        CategoryDto updatedCtg = createCategory(ctg);
        return updatedCtg;
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Optional<Category> opt = categoryRepo.findById(categoryId);
        Category category = opt.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        CategoryDto categoryDto = getCategory(categoryId);
        Category ctg = modelMapper.map(categoryDto, Category.class);
        categoryRepo.delete(ctg);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> ctgList = categoryRepo.findAll();
        List<CategoryDto> ctgDtoList = ctgList.stream().map(c ->  mapToDto(c)).toList();
        return ctgDtoList;
    }
     CategoryDto mapToDto(Category c) {
        CategoryDto ctgDto = modelMapper.map(c,CategoryDto.class);
        return  ctgDto;
    }
}
