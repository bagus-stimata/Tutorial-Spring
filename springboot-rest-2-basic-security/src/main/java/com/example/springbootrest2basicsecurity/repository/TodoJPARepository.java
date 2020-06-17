package com.example.springbootrest2basicsecurity.repository;


import com.example.springbootrest2basicsecurity.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoJPARepository extends JpaRepository<Todo, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}