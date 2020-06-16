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
public class MessageController {
    
    private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

    List<Message> list = new ArrayList<>(Arrays.asList(
        new Message(1, "Singkat", "Bagus"),
        new Message(2, "Surat", "Oke bos")
    ));

    @RequestMapping(value = "/getmessage/{id}", produces = MediaType.APPLICATION_XML_VALUE )
    public Message getPerson(@PathVariable("id") int id){
        return list.get(0); 
    }    


    @RequestMapping(value = "/getallmessage", produces = {MediaType.APPLICATION_XML_VALUE} )
    public List<Message> getAllMessage(){
        return list;
    }

    @PostMapping(value = "/createmessage", consumes = MediaType.APPLICATION_XML_VALUE)
    public void createPerson(@RequestBody Message message){
        list.add(message);
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