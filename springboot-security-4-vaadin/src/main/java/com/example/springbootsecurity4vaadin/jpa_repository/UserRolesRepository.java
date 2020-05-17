package com.example.springbootsecurity4vaadin.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.springbootsecurity4vaadin.model.FUserRoles;



public interface UserRolesRepository extends JpaRepository<FUserRoles, Integer> {
    // Optional<FUser> findByEmail(String email);

    // Optional<FUser> findByUsername(String username);


}
