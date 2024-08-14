package com.example.demo.dtos;

import com.example.demo.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private Set<UserRole> roles;


}
