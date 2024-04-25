package dev.surya.productservice.repository;

import dev.surya.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product entity);
    Product findByIdIs(Long id);

    List<Product> findAll();
}
