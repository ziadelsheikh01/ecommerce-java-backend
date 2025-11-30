package com.MyProjects.E_Commerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private int id ;
    @Column(name = "name", nullable = false , unique = true)
   private String name ;
    @Column(name = "price")
    private double price ;
    @Column(name = "stock")
    private int stock ;


    @ManyToMany (cascade = {CascadeType.DETACH ,CascadeType.PERSIST,CascadeType.MERGE ,CascadeType.REFRESH})
    @JoinTable
            (
                    name = "product_categories"    ,
                    joinColumns = @JoinColumn(name = "product_id") ,
                    inverseJoinColumns = @JoinColumn(name = "category_id")
            )
   // @JsonManagedReference
    @JsonIgnore
    private List<Category> categories ;

    public Product() {
    }

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categoryList) {
        this.categories = categoryList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public void addCategory(Category category)
    {
        if (categories == null)
        {
            categories = new ArrayList<>() ;
        }

        categories.add(category) ;
        category.getProducts().add(this) ;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
