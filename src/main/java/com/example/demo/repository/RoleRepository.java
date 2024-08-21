package com.example.demo.repository;

import com.example.demo.entity.ERole;
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("from Role r where r.name = ?1")
    Optional<Role> findByName(ERole name);

}
