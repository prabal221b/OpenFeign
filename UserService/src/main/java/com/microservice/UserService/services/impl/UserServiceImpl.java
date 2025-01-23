package com.microservice.UserService.services.impl;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.repository.UserRepository;
import com.microservice.UserService.services.ProductClient;
import com.microservice.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductClient productClient;

    public User add(User user){
        return userRepository.save(user);
    }
    public List<User> getAll(){
        List<User> users = userRepository.findAll();
        List<User> userList = users.stream().map( user -> {
            user.setProducts(productClient.getProductsByUser(user.getId()));
            return user;
        }).collect(Collectors.toList());
        return userList;
    }

    public User getById(Long id){
        User user = userRepository.findById(id).orElse(null);
        user.setProducts(productClient.getProductsByUser(user.getId()));
        return user;
    }
}
