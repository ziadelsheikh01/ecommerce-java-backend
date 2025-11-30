package com.MyProjects.E_Commerce.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "order_items")
public class OrderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private int id ;

    @Column(name = "quantity")
    @Positive(message = "quantity must be greater than zero")
    private int quantity ;

    @Column(name = "price")
    @PositiveOrZero(message = "price must be greater than zero")
    private double price ;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    @JsonIgnore
    private Product product ;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull
    @JsonIgnore
    private  Order order ;




    public OrderItem() {
    }

    public OrderItem(int quantity, double price, Product product ) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public  int getProductId ()
    {
        return product.getId();
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
