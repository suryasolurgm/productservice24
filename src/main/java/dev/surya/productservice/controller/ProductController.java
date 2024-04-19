package dev.surya.productservice.controller;

import dev.surya.productservice.dtos.RequestProductDTO;
import dev.surya.productservice.models.Product;
import dev.surya.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    ProductService productService ;
    public ProductController(ProductService productService){
        this.productService =productService;
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody RequestProductDTO requestProductDTO){
        return productService.createProduct(requestProductDTO.getTitle(),requestProductDTO.getImage(),requestProductDTO.getDescription(),requestProductDTO.getCategory(),requestProductDTO.getPrice());

    }
    @GetMapping("/products")
    public ResponseEntity<Product[]> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
       return productService.getSingleProduct(id);
    }
    public void deleteProduct(Long id){

    }
}
