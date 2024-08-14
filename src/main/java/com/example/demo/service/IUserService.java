package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public interface IUserService {
    Boolean addUser(String name, String username, String password);
    Boolean deleteUser(String username);
    Boolean deleteAll();
    Boolean updatePassword(String username, String oldPassword, String newPassword);
    Boolean authenticateUser(String username, String password);
    HashSet<User> getUserList();
}
