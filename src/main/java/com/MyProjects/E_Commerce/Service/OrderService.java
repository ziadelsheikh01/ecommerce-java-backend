package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DAO.OrderDao;
import com.MyProjects.E_Commerce.Entity.Order;

import java.util.List;

public interface OrderService {
    void create( int id) ;
    List<Order> getUerOrders (int userId) ;
    void updateStatus (int orderId , String status);
}
