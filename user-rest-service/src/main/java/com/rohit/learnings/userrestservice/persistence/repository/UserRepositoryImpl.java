package com.rohit.learnings.userrestservice.persistence.repository;


import com.rohit.learnings.userrestservice.persistence.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final static List<User> users = new ArrayList<>();

    private static Integer userCounter = 3;

    static {
        users.add(new User(1, "Rohit", new Date()));
        users.add(new User(2, "Silvanna", new Date()));
        users.add(new User(3, "Rango", new Date()));
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User findUserById(int id) {
        for (User user : users) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++userCounter);
        }
        users.add(user);
        return user;
    }

    @Override
    public User deleteUserById(int id) {
        Iterator<User> usersIterator = users.listIterator();
        while (usersIterator.hasNext()) {
            User user = usersIterator.next();
            if (user.getId() == id) {
                usersIterator.remove();
                return user;
            }
        }
        return null;
    }
}
