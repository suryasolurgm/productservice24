package dev.surya.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends  BaseModel implements Serializable {
    private String title;
    @OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<Product> productList;
}
