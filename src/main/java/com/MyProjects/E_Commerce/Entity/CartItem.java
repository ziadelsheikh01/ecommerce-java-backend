package com.MyProjects.E_Commerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Entity
@Table(name ="cart_items" )
public class CartItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private int id ;


    @Column(name = "quantity")
    @Min(value = 1 , message = "quantity must be greater than one")
    private int quantity ;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @NotNull(message = "product must not be null")
    private  Product product ;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @NotNull(message = "user must not be null")
    private  User user ;
    public CartItem() {
    }

    public CartItem(int quantity , User user , Product product) {
        this.quantity = quantity;
        this.product = product ;
        this.user = user ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
