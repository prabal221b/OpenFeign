package com.microservice.ProductService.controller;

import com.microservice.ProductService.entities.Product;
import com.microservice.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        System.out.println(product.getProductName());

        return productService.add(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Product> getProductByUserId(@PathVariable long userId){
        return productService.findProductsByUserId(userId);
    }
}
