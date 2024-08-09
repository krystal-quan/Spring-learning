package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.HashSet;

public interface UserService {
    Boolean addUser(String name, String username, String password);
    Boolean deleteUser(String username);
    Boolean deleteAll();
    Boolean updatePassword(String username, String oldPassword, String newPassword);
    Boolean authenticateUser(String username, String password);
    HashSet<User> getUserList();
}
