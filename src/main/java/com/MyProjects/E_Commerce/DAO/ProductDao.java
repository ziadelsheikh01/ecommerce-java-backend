package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao
{
    public List<Product> findProducts (String categoryName , String name , BigDecimal minPrice , BigDecimal maxPrice , int page , int size ) ;
    public void add (Product product) ;
    public  void  update (Product product) ;
    public  void delete (Product product) ;
    public  Product findProduct (int id);
    public  Product findByName (String name) ;




}
