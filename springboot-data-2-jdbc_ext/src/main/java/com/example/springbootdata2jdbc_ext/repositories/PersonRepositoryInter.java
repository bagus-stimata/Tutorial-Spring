package com.example.springbootdata2jdbc_ext.repositories;

import java.util.List;

import com.example.springbootdata2jdbc_ext.model.Person;


public interface PersonRepositoryInter {
    
    public int count();
    public int save(Person s);
    public int update(Person s);
    public int deleteByID(int ID);
    
    public List<Person> findAll();
    // public Optional<Person> findByID(int ID);
    public Person findByID(int ID);

}