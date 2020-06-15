package com.example.springbootrest1basic;

import com.example.model.Employee;

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