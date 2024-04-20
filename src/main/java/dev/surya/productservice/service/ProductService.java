package dev.surya.productservice.service;

import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    public Product getSingleProduct(Long id);
    public ResponseEntity<Product[]> getAllProduct();
    public ResponseEntity<Product> createProduct(String title,String Image,String description,String category,double price);
    public ResponseEntity<Product> deleteSingleProduct(Long id);
    public ResponseEntity<String[]> getAllCategory();
    public ResponseEntity<Product[]> getProductByCategory(String category);
}
