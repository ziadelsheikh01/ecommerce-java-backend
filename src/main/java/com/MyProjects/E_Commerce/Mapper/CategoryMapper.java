package com.MyProjects.E_Commerce.Mapper;

import com.MyProjects.E_Commerce.DTO.CategoryDto.CategoryResponse;
import com.MyProjects.E_Commerce.DTO.ProductDto.ProductResponse;
import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    public CategoryResponse toDto(Category category);
    public List<CategoryResponse> toDto(List<Category> categories);
}
