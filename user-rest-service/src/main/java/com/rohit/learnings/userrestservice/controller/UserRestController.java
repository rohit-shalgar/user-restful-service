package com.rohit.learnings.userrestservice.controller;


import com.rohit.learnings.userrestservice.persistence.model.User;
import com.rohit.learnings.userrestservice.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
       return userRepository.findAllUsers();
    }

    @GetMapping(path = "/user/{id}")
    public User findUserById(@PathVariable int id){
        return userRepository.findUserById(id);
    }
}
