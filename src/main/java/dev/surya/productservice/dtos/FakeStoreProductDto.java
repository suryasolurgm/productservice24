package dev.surya.productservice.dtos;

import dev.surya.productservice.models.Category;
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
    private  String image;
    private String description;
    private String category;
    private double price;

}
