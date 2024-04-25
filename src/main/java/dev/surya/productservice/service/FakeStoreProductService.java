package dev.surya.productservice.service;

import dev.surya.productservice.dtos.FakeStoreProductDto;
import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate ;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public ResponseEntity<Product[]> getAllProduct() {
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        FakeStoreProductDto[] productDTOs = response.getBody();
        Product[] products = new Product[productDTOs.length];
        for (int i = 0; i < productDTOs.length; i++) {
            products[i] = new Product();
            products[i] = productDTOs[i].toProduct();
        }
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<Product> createProduct( String title,String Image,String description,String category,double price) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto(title,Image,description,category,price);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto1 = response.getBody();
        Product product = fakeStoreProductDto1.toProduct();
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Product> deleteSingleProduct(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // You can set other headers as needed

        // Create an HttpEntity with the headers
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange("https://fakestoreapi.com/products/"+id,HttpMethod.DELETE,requestEntity,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return  new ResponseEntity<>(fakeStoreProductDto.toProduct(),HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<String[]> getAllCategory() {
        ResponseEntity<String[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",String[].class);
        return  response;
    }

    @Override
    public ResponseEntity<Product[]> getProductByCategory(String category) {
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/category/"+category,FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
        Product[] product = new  Product[fakeStoreProductDtos.length];
        for(int i=0;i<fakeStoreProductDtos.length;i++){
            product[i] =fakeStoreProductDtos[i].toProduct();
        }
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));
    }
}

