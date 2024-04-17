package dev.surya.productservice.service;

import dev.surya.productservice.models.Product;

public interface ProductService {
    public Product getSingleProduct(Long id);
}
