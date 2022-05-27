package com.rohit.learnings.userrestservice.controller;


import com.rohit.learnings.userrestservice.persistence.model.User;
import com.rohit.learnings.userrestservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@SuppressWarnings("unused")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/user/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/user")
    public ResponseEntity<User> createANewUser(@Valid @RequestBody User user) {
        User savedUser = userService.createUser(user);
        URI userLocation = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(userLocation).build();
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
