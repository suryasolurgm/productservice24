package dev.surya.productservice.controller;

import dev.surya.productservice.commons.AuthenticationCommons;
import dev.surya.productservice.dtos.RequestProductDTO;
import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import dev.surya.productservice.models.UserDto;
import dev.surya.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductService productService ;
    private AuthenticationCommons authenticationCommons ;
    public ProductController(@Qualifier("SelfProductService") ProductService productService,
                             AuthenticationCommons authenticationCommons){
        this.productService =productService;
        this.authenticationCommons = authenticationCommons;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id,@RequestHeader("Authorization") String token){
        UserDto userDto = authenticationCommons.validateToken(token);
        if(userDto == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(productService.getSingleProduct(id),HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
            return  productService.deleteSingleProduct(id);
    }
    @GetMapping("/products/category")
    public  ResponseEntity<String[]> getAllCategory(){
        return productService.getAllCategory();
    }
    @GetMapping("/products/category/{category}")
    public ResponseEntity<Product[]> getProductByCategory(@PathVariable("category")String category){
        return productService.getProductByCategory(category);

    }
}
