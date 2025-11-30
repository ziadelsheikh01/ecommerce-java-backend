package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DTO.AddCartRequest;
import com.MyProjects.E_Commerce.Entity.CartItem;

import java.util.List;

public interface CartService
{
    List<CartItem> getCart (int userId) ;
    void addToCart (AddCartRequest addCartRequest , int userId);

    void delete (int cartId) ;

}
