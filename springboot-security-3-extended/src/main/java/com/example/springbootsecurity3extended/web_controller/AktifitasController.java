package com.example.springbootsecurity3extended.web_controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class AktifitasController {
    
    private static final Logger logger = LoggerFactory.getLogger(AktifitasController.class);

    @Autowired
    AktifitasJPARepository aktifitasJPARepository;

    List<Aktifitas> list = new ArrayList<>(Arrays.asList(
        new Aktifitas(1, "Aktifitas 1", null),
        new Aktifitas(2, "Aktifitas 2", null)
    ));

    @RequestMapping(value = "/getaktifitas/{id}", produces = {MediaType.APPLICATION_XML_VALUE} )
    public Aktifitas getAktifitas(@PathVariable("id") int id){
        // return list.get(0); 
        return aktifitasJPARepository.findAll().get(0);
    }    


    @RequestMapping(value = "/getallaktifitas", produces = {MediaType.APPLICATION_XML_VALUE} )
    public List<Aktifitas> getAllMessage(){
        // return list;
        return aktifitasJPARepository.findAll();
    }

    @RequestMapping(value = "/createaktifitas", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_XML_VALUE)
    public void createAktifitas(@RequestBody Aktifitas aktifitas) {
        // list.add(aktifitas);
        aktifitasJPARepository.save(aktifitas);
    }    

      

    // @RequestMapping(value = "/updateperson", method = RequestMethod.PUT )
    // public String updatePerson(@RequestParam Integer id, Person person){
    //     personJPARepository.save(person);
    //     return "redirect:/";
    // }    
    // @RequestMapping(value = "/deleteperson", method = RequestMethod.DELETE )
    // public String updatePerson(@RequestParam Integer id){
    //     personJPARepository.deleteById(id);
    //     return "redirect:/";
    // }    
    



}