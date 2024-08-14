package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService IUserService;

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("message", "Bla bla bla");
        return "Hello World from Controller";
    }

    @PostMapping("/addUser")
    public String addUser(String name, String username, String password) {
        Boolean added = IUserService.addUser(name, username, password);
        return added ? "User added successfully" : "User already exists";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(String username) {
        Boolean deleted = IUserService.deleteUser(username);
        return deleted ? "User deleted successfully" : "User not found";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        Boolean deleted = IUserService.deleteAll();
        return deleted ? "All users deleted successfully" : "No users found";
    }

    @PutMapping("/updatePassword")
    public String updatePassword(String username, String oldPassword, String newPassword) {
        Boolean updated = IUserService.updatePassword(username, oldPassword, newPassword);
        return updated ? "Password updated successfully" : "User not found or password incorrect";
    }

    @GetMapping("/authenticateUser")
    public String authenticateUser(String username, String password) {
        Boolean authenticated = IUserService.authenticateUser(username, password);
        return authenticated ? "User authenticated successfully" : "User not found or password incorrect";
    }

    @GetMapping("/getUserList")
    public HashSet<User> getUserList() {
        return IUserService.getUserList();
    }
}