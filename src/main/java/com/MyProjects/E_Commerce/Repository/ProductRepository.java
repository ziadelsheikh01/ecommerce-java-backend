package com.MyProjects.E_Commerce.Repository;

import com.MyProjects.E_Commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,Integer> , JpaSpecificationExecutor<Product>
{
}
