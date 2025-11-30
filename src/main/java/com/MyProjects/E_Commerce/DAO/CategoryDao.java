package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;

import java.util.List;

public interface CategoryDao
{
    List<Category> getCategories () ;
    Category findCategory (String name) ;

//    List<Product> getCategoryProducts (Category category) ;

    void addCategory(Category category) ;

    void update (Category category) ;

    void delete (Category category) ;


}
