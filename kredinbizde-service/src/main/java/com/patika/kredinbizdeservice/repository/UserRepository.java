package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public UserRepository() {
        User myuser = new User("hakan", "afat", "hakan@test.com", "pass", "1234567890", true);
        myuser.setApplicationList(new ArrayList<>());
        userList.add(myuser);
    }

    public void save(User user) {
        userList.add(user);
    }

    public List<User> getAll() {
        return userList;
    }

    public Optional<User> findByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public void delete(User user) {
        userList.remove(user);
    }

    public User findByUserId(Long userId) {
        return new User();
    }
}
