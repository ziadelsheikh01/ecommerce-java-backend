package com.MyProjects.E_Commerce.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id ;

    @Column(name = "total_price")
    @Min(value = 0 ,message = "total price must not be negative number")
    double totalPrice ;
    @Column(name = "status")
    @NotBlank(message = "status must not be blank")
    @NotNull(message = "status must not be null")
    String status ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "the order must be assigned to user")
    @JsonIgnore
    private  User user ;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderItem>orderItems ;

    public Order(double totalPrice, String status ,User user) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.user = user ;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public  void addOrderItem (OrderItem orderItem)
    {
        if (orderItems == null)
        {
            orderItems = new ArrayList<>();
        }

        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
