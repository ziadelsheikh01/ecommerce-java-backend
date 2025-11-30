package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DAO.CategoryDao;
import com.MyProjects.E_Commerce.DAO.ProductDao;
import com.MyProjects.E_Commerce.DTO.ProductDto.UpdateProductReq;
import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.ExceptionHandler.AlreadyExistsException;
import com.MyProjects.E_Commerce.ExceptionHandler.NotFoundException;
import com.MyProjects.E_Commerce.Repository.ProductRepository;
import com.MyProjects.E_Commerce.Specification.ProductSpecification;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService
{
    ProductDao productDao ;
    ProductRepository productRepository ;
    CategoryDao categoryDao ;

    public ProductServiceImp(ProductDao productDao, ProductRepository productRepository, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.productRepository = productRepository;
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Product> findAll(String categoryName, String name, BigDecimal minPrice, BigDecimal maxPrice, int page, int size) {

        Pageable pageable = PageRequest.of(page,size);
        Specification<Product> specification = Specification.where(
                ProductSpecification.hasCategoryName(categoryName).and(ProductSpecification.hasName(name))
                        .and(ProductSpecification.hasMinPrice(minPrice))
                        .and(ProductSpecification.hasMaxPrice(maxPrice))
        );

        return productRepository.findAll(specification, pageable).getContent();
    }

        @Override
        @Transactional
        public void addProduct(Product product)
        {
            try
            {
                productDao.add(product);
            }
            catch (DataIntegrityViolationException exp)
            {
                throw  new AlreadyExistsException("product already exists");
            }



        }

    @Override
    @Transactional
    public void update(int id ,UpdateProductReq updateProductReq)
    {
        Product product = productDao.findProduct(id) ;
        if (productDao.findProduct(id)== null)
        {
            throw  new NotFoundException("product not found");
        }
        if (updateProductReq.getName() != null )
        {
            product.setName((updateProductReq.getName()));
        }

        if (updateProductReq.getPrice() != null)
        {
            product.setPrice((double)updateProductReq.getPrice());
        }
        if ((updateProductReq.getStock()!= null))
        {
            product.setStock((int)updateProductReq.getStock());
        }

        productDao.update(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Product product = productDao.findProduct(id);
        if (product == null)
        {
            throw  new NotFoundException("product not found");
        }
        productDao.delete(product);
    }

    @Override
    @Transactional
    public void addCategory(String pName, String cName) {

        Product product = productDao.findByName(pName);
        if (product == null)
        {
            throw  new NotFoundException("product not found") ;
        }
        System.out.println("product found");
        Category category = categoryDao.findCategory(cName);
        if (category == null)
        {
            throw  new NotFoundException("category not found");
        }
        System.out.println("Category found");
        if (product.getCategories().contains(category))
        {
            throw  new AlreadyExistsException("category already assigned with product");
        }
        product.addCategory(category);
            productDao.update(product);



    }
}
