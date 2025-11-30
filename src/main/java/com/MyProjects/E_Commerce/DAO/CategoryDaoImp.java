package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImp implements  CategoryDao {

    private EntityManager entityManager ;

    CategoryDaoImp(EntityManager entityManager)
    {
        this.entityManager = entityManager ;
    }
    @Override
    public List<Category> getCategories() {
        TypedQuery<Category> typedQuery = entityManager.createQuery("from Category" , Category.class) ;
        return  typedQuery.getResultList();
    }

    @Override
    public Category findCategory(String name) {
        return entityManager.createQuery("select c from Category c where c.name =:name",Category.class)
                .setParameter("name" , name)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

 /*   @Override
    public List<Product> getCategoryProducts(String name) {
        TypedQuery <Product> typedQuery = entityManager.createQuery("select p from Product p join p.categories c where c.name =: name", Product.class) ;
        typedQuery.setParameter("name" , name);
        return typedQuery.getResultList();

    }*/

    @Override
    public void addCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void update( Category category) {
        entityManager.merge(category);
    }

    @Override
    public void delete(Category category) {
       entityManager.remove(category);
    }




}
