package com.example.springbootsecurity3extended.web_controller;
import com.example.springbootsecurity3extended.jpa_repository.AktifitasJPARepository;
import com.example.springbootsecurity3extended.jpa_repository.PersonJPARepository;
import com.example.springbootsecurity3extended.jpa_repository.TodoJPARepository;
import com.example.springbootsecurity3extended.model.Aktifitas;
import com.example.springbootsecurity3extended.model.Employee;
import com.example.springbootsecurity3extended.model.Message;
import com.example.springbootsecurity3extended.model.Person;
import com.example.springbootsecurity3extended.model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainRestController {
    
    
    @Autowired
    PersonJPARepository personJPARepository;

    @Autowired
    TodoJPARepository todoJPARepository;
    @Autowired
    AktifitasJPARepository aktifitasJPARepository;


    @RequestMapping(value = "/employee", method = RequestMethod.GET,
    produces = { "application/json" })
    public Employee firstPage() {

        Employee emp = new Employee();
        emp.setName("Bagus Winarno Jos Bos");
        emp.setDesignation("manager");
        emp.setId(1);
        emp.setSalary(3000);

        return emp;
    }
    @RequestMapping(value = "/getmessage", produces = "application/json")
	public Message getMessage(){
		return new Message(100, "Congratulations!", "You have accessed a Basic Auth protected resource.");
	}



    @RequestMapping(value = "/getperson", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Person getPerson(){
        return personJPARepository.findAll().get(0);
    }    

    @RequestMapping(value = "/gettodo", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Todo getTodo(){
        return todoJPARepository.findAll().get(0);
    }    

    @RequestMapping(value = "/getaktifitas", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Aktifitas getAktifitas(){
        return aktifitasJPARepository.findAll().get(0);
    }    


}