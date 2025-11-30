package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;

import java.util.List;

public interface CategoryService
{
  List<Category> getCategories() ;
  Category findCategory(String name) ;
  List<Product> getCategoryProducts(String name) ;
  void  addCategory (Category category) ;
  void Update (Category category) ;
  void deleteByName (String name) ;

}
