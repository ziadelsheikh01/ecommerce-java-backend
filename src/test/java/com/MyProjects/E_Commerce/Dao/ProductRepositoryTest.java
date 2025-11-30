package com.MyProjects.E_Commerce.Dao;
import com.MyProjects.E_Commerce.DAO.ProductDao;
import com.MyProjects.E_Commerce.DAO.ProductDaoImp;
import com.MyProjects.E_Commerce.Entity.Product;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

@DataJpaTest
@Import(ProductDaoImp.class)
public class ProductRepositoryTest
{
    @Autowired
    ProductDao productDao ;
    @Autowired
    TestEntityManager testEntityManager;
    @Test
    public  void addAndFindProduct_WithValidData_returnsSavedProduct()
    {
        Product product = new Product("laptop" ,1100 , 50) ;
        productDao.add(product);
        Product p = productDao.findByName("laptop") ;
        Assertions.assertNotNull(p);
        Assertions.assertEquals(p.getName(),product.getName());
    }

    @Test
    public  void addProduct_alreadyExist_throwsException()
    {
        Product product = new Product("laptop",1000,60);
        productDao.add(product);
        Product product2 = new Product("laptop",1000,60);
        Assertions.assertThrows(PersistenceException.class,()-> {
            productDao.add(product2);
        });
    }
   /* @Test
    public  void findProduct_existingProduct_returnProduct()
    {

    }*/

}
