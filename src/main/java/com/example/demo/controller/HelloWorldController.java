package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/api/user")
public class HelloWorldController {
    @Autowired
    UserServiceImpl UserServiceImpl;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World from Controller";
    }

    @PostMapping("/addUser")
    public String addUser(String name, String username, String password) {
        Boolean added = UserServiceImpl.addUser(name, username, password);
        return added ? "User added successfully" : "User already exists";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(String username) {
        Boolean deleted = UserServiceImpl.deleteUser(username);
        return deleted ? "User deleted successfully" : "User not found";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        Boolean deleted = UserServiceImpl.deleteAll();
        return deleted ? "All users deleted successfully" : "No users found";
    }

    @PutMapping("/updatePassword")
    public String updatePassword(String username, String oldPassword, String newPassword) {
        Boolean updated = UserServiceImpl.updatePassword(username, oldPassword, newPassword);
        return updated ? "Password updated successfully" : "User not found or password incorrect";
    }

    @GetMapping("/authenticateUser")
    public String authenticateUser(String username, String password) {
        Boolean authenticated = UserServiceImpl.authenticateUser(username, password);
        return authenticated ? "User authenticated successfully" : "User not found or password incorrect";
    }

    @GetMapping("/getUserList")
    public HashSet<User> getUserList() {
        return UserServiceImpl.getUserList();
    }
}