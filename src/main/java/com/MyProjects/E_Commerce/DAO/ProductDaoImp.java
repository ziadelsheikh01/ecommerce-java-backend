package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDaoImp implements  ProductDao
{
    private EntityManager entityManager ;
    public  ProductDaoImp(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    public List<Product> findProducts(String categoryName, String name, BigDecimal minPrice, BigDecimal maxPrice, int page, int size)
    {
        StringBuilder query = new StringBuilder("select distinct p from Product p left join p.categories c where 1=1 ");
        if (categoryName!=null && !categoryName.isBlank())
        {
            query.append("and lower(c.name) =lower(:cname) ") ;
        }

        if (name!=null && !name.isBlank())
        {
            query.append("and lower(p.name) =lower(:name) ") ;
        }

        if (minPrice != null)
        {
            query.append("and p.price >= :minprice ") ;
        }
        if (maxPrice != null)
        {
            query.append("and p.price <= :maxprice ") ;
        }
        TypedQuery<Product> typedQuery = entityManager.createQuery(query.toString() , Product.class) ;
        if (categoryName!=null && !categoryName.isBlank())
        {
            typedQuery.setParameter("cname" , categoryName) ;
        }

        if (name!=null && !name.isBlank())
        {
            typedQuery.setParameter("name" , name) ;
        }

        if (minPrice != null)
        {
            typedQuery.setParameter("minprice" , minPrice);
        }
        if (maxPrice != null)
        {
            typedQuery.setParameter("maxprice" , maxPrice);
        }
        typedQuery.setFirstResult(page*size) ;
        typedQuery.setMaxResults(size);
        return  typedQuery.getResultList();

    }

    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product )
    {
        entityManager.merge(product) ;
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(product);
    }

    public Product  findProduct (int id)
    {
        return entityManager.find(Product.class,id);
    }

    @Override
    public Product findByName(String name)
    {
       return entityManager.createQuery("select p from Product p where p.name =:name",Product.class)
                .setParameter("name" , name)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }


}
