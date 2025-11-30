package com.MyProjects.E_Commerce.DTO.ProductDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductCategoryReq
{
    @NotBlank
   private String productName ;
    @NotBlank
    private String categoryName ;

    public ProductCategoryReq(String productName, String categoryName) {
        this.productName = productName;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
