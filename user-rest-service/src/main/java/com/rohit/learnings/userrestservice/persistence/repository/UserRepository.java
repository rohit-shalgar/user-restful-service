package com.rohit.learnings.userrestservice.persistence.repository;

import com.rohit.learnings.userrestservice.persistence.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllUsers();

    User findUserById(int id);

    User saveUser(User user);

    User deleteUserById(int id);
}
