package com.rohit.learnings.userrestservice.service;

import com.rohit.learnings.userrestservice.exception.UserNotFoundException;
import com.rohit.learnings.userrestservice.persistence.model.User;
import com.rohit.learnings.userrestservice.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@SuppressWarnings("unused")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAllUsers();
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findUserById(id);
        if(Objects.isNull(user)){
            throw new UserNotFoundException("User with the id -{" + id+"} + was not found");
        }
        return userRepository.findUserById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public User deleteUserById(int id) {
        return null;
    }
}
