package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.Order;

import java.util.List;

public interface OrderDao
{
    public  void create (Order order);
    public List<Order> getUserOrders (int userId);
    public void  updateStatus (int order , String status);
}
