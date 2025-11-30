package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.CartItem;

import java.util.List;

public interface CartDao {
    public List<CartItem> getcart (int userId);
    public  void  addItem (CartItem cartItem);
    public  CartItem findByUserIdAndProductId (int userId , int productId);
    public void deleteCartItem (CartItem cartItem);
    public  CartItem getCartItem (int id);
    public  void deleteUserCart (int userId);

}
