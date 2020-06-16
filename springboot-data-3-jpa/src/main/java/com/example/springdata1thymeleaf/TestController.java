package com.example.springdata1thymeleaf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.example.springdata1thymeleaf.jpa_repository.AktifitasJPARepository;
import com.example.springdata1thymeleaf.jpa_repository.PersonJPARepository;
import com.example.springdata1thymeleaf.jpa_repository.TodoJPARepository;
import com.example.springdata1thymeleaf.model.Aktifitas;
import com.example.springdata1thymeleaf.model.Message;
import com.example.springdata1thymeleaf.model.Person;
import com.example.springdata1thymeleaf.model.Todo;
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
public class TestController {
    
    private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

    List<Person> list = new ArrayList<>(Arrays.asList(
        new Person(1, "Bagus", "Wangkal"),
        new Person(2, "Anis", "Kuwik")
    ));

    // @RequestMapping(value = "/getperson/{id}", produces = {MediaType.APPLICATION_JSON_VALUE} )
    // public Message getPerson(@PathVariable("id") int id){
    //     return 
    // }    


    @RequestMapping(value = "/getalltest", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public List<Person> getAllMessage(){
        return list;
    }

    @PostMapping(value = "/createtest", consumes = "application/json", produces = "application/json")
    public void createPerson(@RequestBody Person person) throws JsonProcessingException {
        list.add(person);
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