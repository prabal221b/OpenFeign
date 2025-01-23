package com.microservice.UserService.services;

import com.microservice.UserService.entities.User;

import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAll();

    User getById(Long id);
}
