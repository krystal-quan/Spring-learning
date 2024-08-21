package com.example.demo.dtos;

import com.example.demo.entity.Role;

import java.util.Set;

public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;


}
