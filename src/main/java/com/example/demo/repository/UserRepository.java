package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.username = ?1")
    Optional<User> findByUsername(String username);

    @Query("from User u where u.username = ?1")
    Optional<User> existsByUsername(String username);


}
