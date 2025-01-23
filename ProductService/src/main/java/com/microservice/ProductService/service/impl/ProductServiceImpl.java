package com.microservice.ProductService.service.impl;

import com.microservice.ProductService.entities.Product;
import com.microservice.ProductService.repository.ProductRepository;
import com.microservice.ProductService.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }
    @Override
    public List<Product> findProductsByUserId(Long id){
        return productRepository.findByUserId(id);
    }
}
