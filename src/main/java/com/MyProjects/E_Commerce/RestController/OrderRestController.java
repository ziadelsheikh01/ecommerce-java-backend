package com.MyProjects.E_Commerce.RestController;

import com.MyProjects.E_Commerce.Entity.Order;
import com.MyProjects.E_Commerce.Entity.OrderItem;
import com.MyProjects.E_Commerce.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderRestController
{
    OrderService orderService ;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/users/{userId}")
    public  void checkout(@PathVariable int userId)
    {
        orderService.create(userId);
    }
    @GetMapping("/users/{userId}")
    public List<Order> userOrders(@PathVariable int userId)
    {
       return orderService.getUerOrders(userId);
    }
    @PutMapping("{id}/status")
    public  void status (@PathVariable int id , @RequestBody String status)
    {
        System.out.println(status);
        orderService.updateStatus(id,status);
    }
}
