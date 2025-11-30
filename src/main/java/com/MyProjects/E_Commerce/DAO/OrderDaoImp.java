package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImp implements  OrderDao
{

    private EntityManager  entityManager ;

    OrderDaoImp(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    public void create(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> getUserOrders(int userId)
    {
        System.out.println(userId);
        TypedQuery<Order> typedQuery = entityManager.createQuery("select o from Order o where o.user.id =:id" , Order.class );
        typedQuery.setParameter("id" , userId);
        return typedQuery.getResultList();
    }

    @Override
    public void updateStatus(int orderId, String status)
    {
        Order order = entityManager.find(Order.class,orderId);
        order.setStatus(status);
    }
}
