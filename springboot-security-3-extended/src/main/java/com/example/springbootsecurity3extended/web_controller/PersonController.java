package com.example.springbootsecurity3extended.web_controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;


import com.example.springbootsecurity3extended.jpa_repository.AktifitasJPARepository;
import com.example.springbootsecurity3extended.jpa_repository.PersonJPARepository;
import com.example.springbootsecurity3extended.jpa_repository.TodoJPARepository;
import com.example.springbootsecurity3extended.model.Aktifitas;
import com.example.springbootsecurity3extended.model.Message;
import com.example.springbootsecurity3extended.model.Person;
import com.example.springbootsecurity3extended.model.Todo;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {
    
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonJPARepository personJPARepository;

    List<Person> list = new ArrayList<>(Arrays.asList(
        new Person(1, "Person 1", null),
        new Person(2, "Person 2", null)
    ));

    @RequestMapping(value = "/getperson/{id}", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Person getAktifitas(@PathVariable("id") int id){
        // return list.get(0); 
        return personJPARepository.findById(id);
    }    


    @RequestMapping(value = "/getallperson", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public List<Person> getAllMessage(){
        // return list;
        return personJPARepository.findAll();
    }

    @RequestMapping(value = "/createperson", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person createAktifitas(@RequestBody Person person) {
        // list.add(person);
        return personJPARepository.save(person);       
    }    

    @RequestMapping(value = "/updateperson/{id}", method = RequestMethod.PUT )
    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody Person person){
        Person newPerson = personJPARepository.findById(id).orElse(new Person());
        if (newPerson !=null) {
            newPerson.setName(person.getName());
            newPerson.setAddress(person.getAddress());
            personJPARepository.save(newPerson);
        }

        return newPerson;
    }    
    
    @RequestMapping(value = "/deleteperson/{id}", method = RequestMethod.DELETE )
    public Person updatePerson(@PathVariable("id") Integer id){
        Optional<Person> newPerson = personJPARepository.findById(id);
        if (! newPerson.isEmpty()) {
            personJPARepository.delete(newPerson.get());
        }
        
        return newPerson.orElse(new Person());
    }    
    



}