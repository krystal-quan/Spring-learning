package com.example.demo.entity;

//import lombok.Getter;
//import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
public class User {
    @Setter
    @JsonProperty("username")
    @NotBlank
    String username;

    @JsonProperty("password")
    @NotBlank
    String password;

    @Setter
    @JsonProperty("name")
    @NotBlank
    String name;

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
        //Encrypt using SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean checkPassword(String password) {
        return this.encryptPassword(password).equals(this.password);
    }
}
