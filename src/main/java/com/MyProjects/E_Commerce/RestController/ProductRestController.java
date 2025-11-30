package com.MyProjects.E_Commerce.RestController;

import com.MyProjects.E_Commerce.DTO.ProductDto.AddProductRequest;
import com.MyProjects.E_Commerce.DTO.ProductDto.ProductResponse;
import com.MyProjects.E_Commerce.DTO.ProductDto.UpdateProductReq;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.Mapper.ProductMapper;
import com.MyProjects.E_Commerce.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductRestController
{
    private ProductService productService ;
    private ProductMapper productMapper;
    ProductRestController(ProductService productService, ProductMapper productMapper)
    {
        this.productService = productService ;
        this.productMapper = productMapper ;
    }

    @GetMapping
    public List<ProductResponse> findProduct(@RequestParam(required = false) String categoryName ,
                                             @RequestParam(required = false ) String name ,
                                             @RequestParam(required = false)BigDecimal minPrice ,
                                             @RequestParam(required = false)BigDecimal maxPrice ,
                                             @RequestParam (defaultValue ="0") int page ,
                                             @RequestParam(defaultValue = "10")int size
                                     )
    {

       return productMapper.toDto(productService.findAll(categoryName,name,minPrice,maxPrice,page,size));

    }
    @PostMapping
    public void add(@RequestBody @Valid AddProductRequest addProductRequest)
    {
        productService.addProduct(productMapper.toEntity(addProductRequest));
    }

    @PutMapping("/{id}")
    public  void update (@PathVariable int id, @RequestBody @Valid UpdateProductReq updateProductReq)
    {
        productService.update(id,updateProductReq);
    }
    @DeleteMapping ("{id}")
    public  void delete (@PathVariable int id)
    {
        productService.delete(id) ;
    }

    @PostMapping("/{productName}/categories/{categoryName}")
    public void addCategory(@PathVariable String productName , @PathVariable String categoryName)
    {
        productService.addCategory(productName,categoryName);
    }


   /* @PostMapping
    public void addcategory(@RequestBody ProductCategoryReq productCategoryReq)
    {

        productService.addCategory(productCategoryReq.getProductName(),productCategoryReq.getCategoryName());
    }*/
}
