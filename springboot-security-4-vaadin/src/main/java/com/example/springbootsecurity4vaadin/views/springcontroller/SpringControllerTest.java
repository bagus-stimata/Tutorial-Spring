package com.example.springbootsecurity4vaadin.views.springcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spring-controller")
public class SpringControllerTest {
    
    @GetMapping
    public String springTest(Model modelView){

        return "spring-test";
    }

}