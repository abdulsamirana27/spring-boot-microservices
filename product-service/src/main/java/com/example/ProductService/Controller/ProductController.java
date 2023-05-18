package com.example.ProductService.Controller;

import com.example.ProductService.dto.ProductRequest;
import com.example.ProductService.dto.ProductResponse;
import com.example.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        try {
         productService.createProduct(productRequest);
        }catch (Exception e){
            System.out.println(e);
        }
     }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProduct(){
       return productService.getAllProducts();
    }
}
