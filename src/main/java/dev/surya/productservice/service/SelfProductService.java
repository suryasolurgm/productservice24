package dev.surya.productservice.service;

import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import dev.surya.productservice.repository.CategoryRepository;
import dev.surya.productservice.repository.ProductRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("SelfProductService")
public class SelfProductService implements  ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return productRepository.findByIdIs(id);

    }

    @Override
    public ResponseEntity<Product[]> getAllProduct() {
        return new ResponseEntity<>(productRepository.findAll().toArray(new Product[0]),HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Product> createProduct(String title, String Image, String description, String category, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setImageUrl(Image);
        product.setDescription(description);
        product.setPrice(price);
        Category categorybydatabase = categoryRepository.findByTitle(category);
        if(categorybydatabase==null){
            Category category1 = new Category();
            category1.setTitle(category);
            categorybydatabase =categoryRepository.save(category1);
        }
        product.setCategory(categorybydatabase);
        return new ResponseEntity<>(productRepository.save(product), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Product> deleteSingleProduct(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<String[]> getAllCategory() {
        return null;
    }

    @Override
    public ResponseEntity<Product[]> getProductByCategory(String category) {
        return null;
    }
}
