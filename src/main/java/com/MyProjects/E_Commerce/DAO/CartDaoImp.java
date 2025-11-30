package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.CartItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImp implements  CartDao
{
    private EntityManager entityManager ;

    public CartDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List <CartItem> getcart (int userId)
    {
        TypedQuery<CartItem> typedQuery = entityManager.createQuery("select ci from CartItem ci join fetch ci.product where ci.user.id =: id" , CartItem.class) ;
        typedQuery.setParameter("id" , userId) ;

        return typedQuery.getResultList();

    }

    @Override
    public void addItem(CartItem cartItem)
    {
       entityManager.persist(cartItem);
    }

    @Override
    public CartItem findByUserIdAndProductId(int userId, int productId) {
      try {
          TypedQuery<CartItem> typedQuery = entityManager.createQuery("select ci from CartItem ci where ci.user.id =:uid and ci.product.id = :pid",CartItem.class);
          typedQuery.setParameter("uid" , userId);
          typedQuery.setParameter("pid" , productId);
          CartItem cartItem =typedQuery.getSingleResult();
          return cartItem ;
      }

      catch (NoResultException exp)
      {
          return  null;
      }

    }


    public  CartItem getCartItem (int id)
    {
        return  entityManager.find(CartItem.class,id);
    }
    @Override
    public void deleteCartItem(CartItem cartItem)
    {

        entityManager.remove(cartItem);

    }

    @Override
    public void deleteUserCart(int userId)
    {
        Query query = entityManager.createQuery("delete from CartItem ci  where ci.user.id =:id" ) ;
        query.setParameter("id" , userId) ;
        query.executeUpdate();

    }
}
