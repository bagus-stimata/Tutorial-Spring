package com.example.springsecurity1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexView{
    public IndexView() {
    }

    @RequestMapping("/")
    public String index(){
        return "Index from Spring Boot Bagus";
    }

    @RequestMapping("/home")
    public String hello(){
        return "Home from Spring Boot Bagus";
    }


    

}