package com.example.demo.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Boolean addUser(String name, String username, String password) {
        User checkUser = userRepository.findByUsername(username);
        if (checkUser != null) {
            return false;
        }
        User user = new User(username, password, name);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean deleteAll() {
        userRepository.deleteAll();
        return true;
    }

    @Override
    public Boolean updatePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(user.encryptPassword(oldPassword))) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(user.encryptPassword(password));
    }

    @Override
    public HashSet<User> getUserList() {
        return new HashSet<>(userRepository.findAll());
    }
}
