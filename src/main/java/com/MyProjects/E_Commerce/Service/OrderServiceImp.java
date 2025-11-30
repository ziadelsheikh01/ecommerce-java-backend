package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DAO.CartDao;
import com.MyProjects.E_Commerce.DAO.OrderDao;
import com.MyProjects.E_Commerce.Entity.CartItem;
import com.MyProjects.E_Commerce.Entity.Order;
import com.MyProjects.E_Commerce.Entity.OrderItem;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.ExceptionHandler.NotFoundException;
import com.MyProjects.E_Commerce.ExceptionHandler.OutOfStockException;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp  implements  OrderService
{
    private OrderDao orderDao ;
    private CartDao cartDao;

    public OrderServiceImp(OrderDao orderDao, CartDao cartDao)
    {
        this.orderDao = orderDao;
        this.cartDao = cartDao;
    }

    @Override
    @Transactional
    public void create( int userId)
    {
        List<CartItem> cart = cartDao.getcart(userId);
        List<OrderItem> orderItems = new ArrayList<>();
        if (cart.isEmpty())
        {
            throw  new NotFoundException("Cart is empty") ;
        }

        int totalPrice = 0 ;
        for (var c: cart)
        {
            Product product = c.getProduct();
            int productStock = product.getStock();
            int itemQuantity = c.getQuantity();
            double price = itemQuantity * product.getPrice() ;
            totalPrice += price ;

            if (productStock - itemQuantity < 0 )
            {
                throw  new OutOfStockException("product out of stock, only remain : " + productStock);
            }
            orderItems.add(new OrderItem(itemQuantity,price,product));
            product.setStock(productStock- itemQuantity);
        }
        cartDao.deleteUserCart(userId);
        Order order = new Order(totalPrice , "Not Delivered" , cart.getFirst().getUser());
        for (var i :orderItems) {
            order.addOrderItem(i);
        }


        orderDao.create(order);

    }

    @Override
    public List<Order> getUerOrders(int userId) {
        return orderDao.getUserOrders(userId);
    }

    @Override
    @Transactional
    public void updateStatus(int orderId, String status) {
        orderDao.updateStatus(orderId,status);
    }
}
