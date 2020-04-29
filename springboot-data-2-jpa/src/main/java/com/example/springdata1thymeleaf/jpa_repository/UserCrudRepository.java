package com.example.springdata1thymeleaf.jpa_repository;

import com.example.springdata1thymeleaf.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<Person, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}