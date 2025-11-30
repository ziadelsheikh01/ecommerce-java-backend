package com.MyProjects.E_Commerce.DTO.ProductDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UpdateProductReq
{
    @Size(min = 2 , max = 55 , message = "name size is must be between 2 and 55")
    private String name ;

    @PositiveOrZero(message = "price should be non negative value")
    private Double price ;

    @PositiveOrZero(message = "price should be non negative value")
    private Integer stock ;

    public  UpdateProductReq()
    {

    }
    public UpdateProductReq(String name, double price, int stock) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "UpdateProductReq{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
