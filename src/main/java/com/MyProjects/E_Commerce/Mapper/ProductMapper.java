package com.MyProjects.E_Commerce.Mapper;

import com.MyProjects.E_Commerce.DTO.ProductDto.AddProductRequest;
import com.MyProjects.E_Commerce.DTO.ProductDto.ProductResponse;
import com.MyProjects.E_Commerce.Entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper
{
    public Product toEntity (AddProductRequest addProductRequest);

    public List<ProductResponse> toDto(List<Product> products);
    public ProductResponse toDto(Product product);
}
