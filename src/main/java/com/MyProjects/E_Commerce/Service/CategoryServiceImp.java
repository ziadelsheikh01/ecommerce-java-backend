package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DAO.CategoryDao;
import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.ExceptionHandler.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImp  implements  CategoryService{

    private CategoryDao categoryDao ;

    public CategoryServiceImp(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao ;
     }
    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public Category findCategory(String name)
    {
        Category category= categoryDao.findCategory(name);
        if (category == null)
        {
            throw  new NotFoundException("Category is not found") ;
        }
        return  category;
    }

    @Override
    public List<Product> getCategoryProducts(String name)
    {
        Category category = categoryDao.findCategory(name);
        if (category == null)
        {
            throw new NotFoundException("Category not found");
        }
        return category.getProducts();

    }

    @Override
    @Transactional
    public void addCategory(Category category)

    {
        categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public void Update(Category category) {
        categoryDao.update(category);
    }

    @Override
    @Transactional
    public void deleteByName(String name)
    {
        Category category = categoryDao.findCategory(name) ;
        if (category == null)
        {
            throw  new NotFoundException("Category Not found") ;
        }

        categoryDao.delete(category);
    }

}
