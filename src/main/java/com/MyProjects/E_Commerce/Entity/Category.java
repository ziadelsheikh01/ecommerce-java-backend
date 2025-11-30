package com.MyProjects.E_Commerce.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @NotBlank(message = "the name must not be blank ")
    @Column(name = "name")
    private String name;


    @ManyToMany(fetch =FetchType.LAZY, mappedBy = "categories")
    private List<Product> products ;

    public Category() {
    }

    public Category( String name) {
        this.name = name;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void addProduct(Product product)
    {
        if (product == null)
        {
            products = new ArrayList<>() ;
        }
        products.add(product);
        product.getCategories().add(this);

    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
