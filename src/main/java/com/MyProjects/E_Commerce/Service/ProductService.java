package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DTO.ProductDto.UpdateProductReq;
import com.MyProjects.E_Commerce.Entity.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findAll (String categoryName , String name , BigDecimal minPrice , BigDecimal maxPrice , int page , int size);
    void addProduct (Product product) ;
    void update (int id,UpdateProductReq product) ;
    void delete (int id);
    void addCategory (String pName ,String cName ) ;

}
