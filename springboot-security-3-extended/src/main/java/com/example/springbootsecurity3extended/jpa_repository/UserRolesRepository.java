package com.example.springbootsecurity3extended.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.springbootsecurity3extended.model.FUser;
import com.example.springbootsecurity3extended.model.FUserRoles;


public interface UserRolesRepository extends JpaRepository<FUserRoles, Integer> {
    // Optional<FUser> findByEmail(String email);

    // Optional<FUser> findByUsername(String username);


}
