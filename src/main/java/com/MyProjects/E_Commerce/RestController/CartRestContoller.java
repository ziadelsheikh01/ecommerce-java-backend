package com.MyProjects.E_Commerce.RestController;

import com.MyProjects.E_Commerce.DTO.AddCartRequest;
import com.MyProjects.E_Commerce.Entity.CartItem;
import com.MyProjects.E_Commerce.Service.CartService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{id}/cart")
public class CartRestContoller {
    private CartService cartService ;

    public CartRestContoller(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCart(@PathVariable int id)
    {
        return  cartService.getCart(id);
    }
    @PostMapping
    public  void  addItem (@RequestBody @Valid AddCartRequest addCartRequest , @PathVariable int id)
    {
        cartService.addToCart(addCartRequest,id);
    }
    @DeleteMapping("/{cartItemId}")
    public  void delete ( @PathVariable int cartItemId)
    {
        cartService.delete(cartItemId);
    }
}
