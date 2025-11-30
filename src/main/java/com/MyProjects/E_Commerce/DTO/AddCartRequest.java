package com.MyProjects.E_Commerce.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddCartRequest {
    @Min(value = 1 , message = "quantity must be greater than zero")
   private int quantity ;
    @Min(value =  1 , message = "product id must be greater than zero")
    private int productId ;

    public AddCartRequest(int quantity, int productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
