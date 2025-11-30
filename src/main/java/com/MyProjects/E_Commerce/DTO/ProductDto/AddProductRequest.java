package com.MyProjects.E_Commerce.DTO.ProductDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class AddProductRequest
{


    @NotBlank(message = "name field is required")
    @Size(min = 2 , max = 100 , message = "the name size should be between 2 and 100")
    private String name ;

    @PositiveOrZero(message = "price should be positive number or zero")
    @NotNull
    private double price ;

    @NotNull (message = "Stock field is required")
    @PositiveOrZero(message = "stock cannot be negative")
    private  int stock ;
    public AddProductRequest()
    {

    }
    public AddProductRequest(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "AddProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
