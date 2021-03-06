package com.example.springbootsecurity1basic.main_controller;



import com.example.springbootsecurity1basic.model.Employee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    
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

}