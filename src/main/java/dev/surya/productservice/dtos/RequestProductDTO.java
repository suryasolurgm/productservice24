package dev.surya.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestProductDTO {
    private String title;
    private  String Image;
    private String description;
    private String category;
    private double price;
}
