package dev.surya.productservice.repository;

import dev.surya.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByTitle(String title);
    Category save(Category entity);
}
