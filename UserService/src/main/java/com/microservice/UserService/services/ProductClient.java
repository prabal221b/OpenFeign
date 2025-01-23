package com.microservice.UserService.services;

import com.microservice.UserService.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(url="http://localhost:8081", value = "Product-Client")
public interface ProductClient {
    @GetMapping("/products/user/{userId}")
    public List<Product> getProductsByUser(@PathVariable long userId);
}
