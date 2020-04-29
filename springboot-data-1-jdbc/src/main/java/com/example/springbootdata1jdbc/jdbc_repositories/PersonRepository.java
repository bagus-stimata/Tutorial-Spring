package com.example.springbootdata1jdbc.jdbc_repositories;

import java.util.List;
import java.util.Optional;

import com.example.springbootdata1jdbc.Person;

public interface PersonRepository {
    
    public int count();
    public int save(Person s);
    public int update(Person s);
    public int deleteByID(int ID);
    
    public List<Person> findAll();
    // public Optional<Person> findByID(int ID);
    public Person findByID(int ID);

}