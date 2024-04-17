package dev.surya.productservice.controller;

import dev.surya.productservice.models.Product;
import dev.surya.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService ;
    public ProductController(ProductService productService){
        this.productService =productService;
    }
    @PostMapping("/products")
    public void createProduct(){

    }
    @GetMapping("/products")
    public void getAllProduct(){

    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
       return productService.getSingleProduct(id);
    }
    public void deleteProduct(Long id){

    }
}
