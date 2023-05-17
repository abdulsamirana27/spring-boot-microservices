package com.example.MicroService.Controller;

import com.example.MicroService.dto.ProductRequest;
import com.example.MicroService.dto.ProductResponse;
import com.example.MicroService.model.Product;
import com.example.MicroService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
