package com.microservice.ProductService.service;

import com.microservice.ProductService.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product add(Product product);

    List<Product> findAll();

    Product findById(Long id);

    List<Product> findProductsByUserId(Long id);
}

