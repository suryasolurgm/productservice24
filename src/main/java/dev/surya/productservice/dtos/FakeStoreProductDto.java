package dev.surya.productservice.dtos;

import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDto {
    private  Long id;
    private String title;
    private  String Image;
    private String description;
    private String category;
    private double price;

    public FakeStoreProductDto(String title, String image, String description, String category, double price) {
        this.title=title;
        this.Image=image;
        this.description=description;
        this.category=category;
        this.price=price;
    }

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setImageUrl(getImage());
        product.setPrice(getPrice());
        Category category = new Category();
        category.setTitle(getCategory());
        product.setCategory(category);
        return product;
    }

}
