package com.example.springboot2thymeleaf.rest_controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class MyRestController {


    @GetMapping(value= "/users")
    public String rest_Users(){
        return "Hello User";
    }
    
    /*
      JSon lebih direcommended dari pada XML oleh karena masalah compatibilitas
    */
    @GetMapping(value= "/users_json", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public UserRest rest_Users_Json(){
        UserRest user1 = new UserRest(1, "Bagus Winarno");
       
        return user1;
    }

    @GetMapping(value= "/users_json/{pathVariable_name}", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public UserRest rest_Users_Json(@PathVariable String pathVariable_name){
        UserRest user1 = new UserRest(1, pathVariable_name);
        return user1;
    }

    @GetMapping(value= "/list_users_json", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public List<UserRest> rest_ListUsers_Json(){
        
        UserRest user1 = new UserRest(1, "Bagus Winarno");
        UserRest user2 = new UserRest(2, "Anis Winarni");
       
        return Arrays.asList(user1, user2);
    }

    
}

class UserRest{
    int ID = 0;
    String nama ="";
    

    public UserRest(){}
    public UserRest(int iD, String nama) {
        ID = iD;
        this.nama = nama;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    
}