package com.MyProjects.E_Commerce.Specification;

import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification
{
    public  static Specification<Product> hasName (String name)
    {
        return ((root, query, criteriaBuilder) ->
                name == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")) , "%" + name.toLowerCase() + "%"));
    }

    public  static  Specification<Product> hasCategoryName (String CategoryName)
    {
        return ((root, query, criteriaBuilder) ->
                CategoryName == null ? null :
                        criteriaBuilder.equal(criteriaBuilder.lower(root.join("categories").get("name")),CategoryName.toLowerCase() )
                );
    }

    public  static  Specification<Product> hasMinPrice (BigDecimal minPrice)
    {
        return ((root, query, criteriaBuilder) ->
                minPrice == null ? null :
                        criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice)
        );
    }


    public  static  Specification<Product> hasMaxPrice (BigDecimal maxPrice)
    {
        return ((root, query, criteriaBuilder) ->
                maxPrice == null ? null :
                        criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice)
        );
    }
}
