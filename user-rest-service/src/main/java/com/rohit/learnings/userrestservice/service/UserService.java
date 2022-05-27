package com.rohit.learnings.userrestservice.service;

import com.rohit.learnings.userrestservice.persistence.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);

    User deleteUserById(int id);
}
