package com.example.springdata1thymeleaf.jpa_repository;

import com.example.springdata1thymeleaf.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoCrudRepository extends JpaRepository<Todo, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}