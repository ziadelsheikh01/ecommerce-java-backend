package com.MyProjects.E_Commerce.Service;


import com.MyProjects.E_Commerce.DAO.CartDao;
import com.MyProjects.E_Commerce.DAO.ProductDao;
import com.MyProjects.E_Commerce.DAO.UserDao;
import com.MyProjects.E_Commerce.DTO.AddCartRequest;
import com.MyProjects.E_Commerce.Entity.CartItem;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.Entity.User;
import com.MyProjects.E_Commerce.ExceptionHandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImp implements  CartService
{
   private CartDao cartDao ;
   private ProductDao productDao ;
   private UserDao userDao ;


   @Autowired
    public CartServiceImp(CartDao cartDao, ProductDao productDao, UserDao userDao) {
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.userDao = userDao;
    }

    @Override
    public List<CartItem> getCart(int userId) {
        return cartDao.getcart(userId);
    }

    @Override
    @Transactional
    public void addToCart(AddCartRequest addCartRequest, int userId)
    {

        User user = userDao.findById(userId).orElseThrow(()-> new NotFoundException("user not found"));
        Product product = productDao.findProduct(addCartRequest.getProductId()) ;
        if (product == null)
        {
            throw  new NotFoundException("product not found") ;
        }
        CartItem cartItem = cartDao.findByUserIdAndProductId(userId,addCartRequest.getProductId()) ;
        int quantityReq = addCartRequest.getQuantity();
        if (cartItem == null)
        {
            cartItem = new CartItem(quantityReq,user , product);
            cartDao.addItem(cartItem);
        }

        else
        {

            cartItem.setQuantity(cartItem.getQuantity()+ quantityReq);
        }


    }

    @Override
    @Transactional
    public void delete(int id)
    {
        CartItem cartItem = cartDao.getCartItem(id);
        if (cartItem == null)
        {
            throw  new NotFoundException("the cart item is not found") ;
        }
        cartDao.deleteCartItem(cartItem);
    }
}
