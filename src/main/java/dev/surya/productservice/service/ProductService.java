package dev.surya.productservice.service;

import dev.surya.productservice.models.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    public Product getSingleProduct(Long id);
    public ResponseEntity<Product[]> getAllProduct();
    public ResponseEntity<Product> createProduct(String title,String Image,String description,String category,double price);
}
