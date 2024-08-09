package com.example.demo.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    public HashSet<User> userList = new HashSet<>();

    @Override
    public Boolean addUser(String name, String username, String password) {
        User user = new User(username, password, name);
        return userList.add(user);
    }

    @Override
    public Boolean deleteUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return userList.remove(user);
            }
        }
        return false;
    }

    @Override
    public Boolean deleteAll() {
        userList.clear();
        return true;
    }

    @Override
    public Boolean updatePassword(String username, String oldPassword, String newPassword) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(user.encryptPassword(oldPassword))) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean authenticateUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(user.encryptPassword(password))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public HashSet<User> getUserList() {
        return userList;
    }
}
