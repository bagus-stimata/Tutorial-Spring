package com.example.springbootrest3security.main_controller;



import java.util.ArrayList;
import java.util.List;

import com.example.springbootrest3security.jpa_repository.UsersRepository;
import com.example.springbootrest3security.model.Employee;
import com.example.springbootrest3security.model.FUser;
import com.example.springbootrest3security.model.FUserRoles;
import com.example.springbootrest3security.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    
    @Autowired
    UsersRepository userRepository;
    
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

    @RequestMapping(value = "/fuser", method = RequestMethod.GET,
        produces = { MediaType.APPLICATION_JSON_VALUE} )
    public FUser fuser(){
        FUser pengguna = new FUser();
        pengguna.setID(1);
        pengguna.setUsername("Bagus Winarno");

        List<FUserRoles> list = new ArrayList<>();    
        FUserRoles userRole1 = new FUserRoles();
        userRole1.setFuserBean(pengguna);
        userRole1.setRoleID(Role.ADMIN);
        list.add(userRole1);

        pengguna.setFuserRoles(list);


        // return userRepository.findAll().get(0);
        return pengguna;
    }

}