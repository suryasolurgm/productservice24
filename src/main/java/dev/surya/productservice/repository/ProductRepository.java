package dev.surya.productservice.repository;

import dev.surya.productservice.models.Product;
import dev.surya.productservice.repository.projections.ProductWithTitleAndId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product entity);
    Product findByIdIs(Long id);

    List<Product> findAll();
    @Query("select p from Product p where p.category.title=:title and p.id=:id")
    Product getProductwithspeciefiedTitleandId(@Param("title") String title,@Param("id") Long id);

    @Query("select p.id as id,p.title as title from Product p where p.category.title=:title and p.id=:id")
    ProductWithTitleAndId getProductwithspeciefiedTitleandId2(@Param("title") String title, @Param("id") Long id);
}
