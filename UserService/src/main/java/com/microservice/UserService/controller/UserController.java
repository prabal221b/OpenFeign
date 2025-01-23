package com.microservice.UserService.controller;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.add(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getById(id);
    }
}
