package com.rohit.learnings.userrestservice.controller;


import com.rohit.learnings.userrestservice.persistence.model.User;
import com.rohit.learnings.userrestservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@SuppressWarnings("unused")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users/uris")
    public EntityModel<Object> getAllUserUris(){

        Class<? extends UserRestController> userRestController = this.getClass();
        User user = new User();
        int userId = 0;
        EntityModel<Object> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkToAllUsers =  linkTo(WebMvcLinkBuilder.methodOn(userRestController).getAllUsers());
        WebMvcLinkBuilder linkToASingleUserById = linkTo(WebMvcLinkBuilder.methodOn(userRestController).findUserById(userId));
        WebMvcLinkBuilder linkToCreateAUser = linkTo(WebMvcLinkBuilder.methodOn(userRestController).createANewUser(user));
        WebMvcLinkBuilder linkToDeletingASingleUser = linkTo(WebMvcLinkBuilder.methodOn(userRestController).deleteUserById(userId));

        entityModel.add(linkToAllUsers.withRel("Retrieve all users"));
        entityModel.add(linkToASingleUserById.withRel("Retrieve a single user by Id."));
        entityModel.add(linkToCreateAUser.withRel("Create a new user"));
        entityModel.add(linkToDeletingASingleUser.withRel("Delete a single user by Id."));

        return entityModel;

    }

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
