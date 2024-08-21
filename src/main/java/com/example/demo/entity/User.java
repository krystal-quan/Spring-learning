package com.example.demo.entity;

//import lombok.Getter;
//import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class User {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Id
    @NotNull
    @JsonProperty("user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @JsonProperty("username")
    @NotBlank
    @Column(name = "username", unique = true, nullable = false, length = 20)
    @Size(min = 6, max = 20)
    String username;

    @JsonProperty("password")
    @NotBlank
    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 20)
    String password;

    @Setter
    @JsonProperty("name")
    @NotBlank
    @Column(name = "name", nullable = false)
    @Size(min = 6, max = 50)
    String name;

    @JsonProperty("roles")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();


    public User() {
    }

    public User(String username, String password, String name) {
        this.username = username;
        this.password = this.encryptPassword(password);
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = this.encryptPassword(password);
    }

    public String encryptPassword(String password) {
        //Encrypt using BCryptPasswordEncoder
        return passwordEncoder.encode(password);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean checkPassword(String password) {
        return this.encryptPassword(password).equals(this.password);
    }
}
