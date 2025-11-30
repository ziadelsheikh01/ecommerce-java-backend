package com.MyProjects.E_Commerce.RestController;

import com.MyProjects.E_Commerce.DTO.CategoryDto.CategoryResponse;
import com.MyProjects.E_Commerce.DTO.ProductDto.ProductResponse;
import com.MyProjects.E_Commerce.Entity.Category;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.Mapper.CategoryMapper;
import com.MyProjects.E_Commerce.Mapper.ProductMapper;
import com.MyProjects.E_Commerce.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController
{
    private CategoryService categoryService ;
    private CategoryMapper categoryMapper;
    private ProductMapper productMapper ;
    CategoryRestController(CategoryService categoryService , CategoryMapper categoryMapper , ProductMapper productMapper)
    {

        this.categoryService =categoryService;
        this.categoryMapper = categoryMapper;
        this.productMapper = productMapper ;
    }


    @GetMapping
    public List<CategoryResponse> getCategories()
    {
        return categoryMapper.toDto(categoryService.getCategories()) ;
    }
    @GetMapping("/{name}")
    public CategoryResponse find_Category(@PathVariable String name)
    {
        return categoryMapper.toDto(categoryService.findCategory(name));
    }
    @GetMapping("{name}/products")
    public  List<ProductResponse> getCategoryProducts(@PathVariable String name)
    {
        System.out.println("started the method");
        return productMapper.toDto(categoryService.getCategoryProducts(name));
    }

    @PostMapping
    public  void addCategory (@RequestBody @Valid Category category)
    {
        categoryService.addCategory(category);
    }

    @PutMapping
    public  void update(@RequestBody @Valid Category category)
    {
        categoryService.Update(category);
    }

    @DeleteMapping ("/{name}")
    public  void delete (@PathVariable String name)
    {
        categoryService.deleteByName(name);
    }


}
