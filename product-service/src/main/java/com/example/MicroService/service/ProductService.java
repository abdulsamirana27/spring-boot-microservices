package com.example.MicroService.service;

import com.example.MicroService.Repository.ProductRepository;
import com.example.MicroService.dto.ProductRequest;
import com.example.MicroService.dto.ProductResponse;
import com.example.MicroService.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product"+product.getId()+ "is saved");

    }

    public List<ProductResponse> getAllProducts(){
       List<Product> products = productRepository.findAll();

      return products.stream().map(this::mapToProductResponse).toList();

    }
    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}
