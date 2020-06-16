package com.example.springdata1thymeleaf;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.example.springdata1thymeleaf.jpa_repository.AktifitasJPARepository;
import com.example.springdata1thymeleaf.jpa_repository.PersonJPARepository;
import com.example.springdata1thymeleaf.jpa_repository.TodoJPARepository;
import com.example.springdata1thymeleaf.model.Aktifitas;
import com.example.springdata1thymeleaf.model.Person;
import com.example.springdata1thymeleaf.model.Todo;

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
public class MainRestController {
    
    private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

    @Autowired
    PersonJPARepository personJPARepository;

    @Autowired
    TodoJPARepository todoJPARepository;
    @Autowired
    AktifitasJPARepository aktifitasJPARepository;


 

    @RequestMapping(value = "/getperson/{id}", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Person getPerson(@PathVariable("id") int id){
        return personJPARepository.findByID(id);
    }    
    @RequestMapping(value = "/getallperson", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public List<Person> getAllPerson(){
        return personJPARepository.findAll();
    }

    @PostMapping(value = "/createperson", consumes = "application/json", produces = "application/json")
    public Person createPerson(@RequestBody Person person){
       
        logger.debug("Hello ini dipanggil");
        return personJPARepository.save(person);
    }    

    // @PostMapping(value = "/createperson", consumes = "application/json", produces = "application/json")
    // public Person createPerson(){
       
    //     logger.debug("Hello ini dipanggil");
    //     return personJPARepository.save(person);
    // }    

    @RequestMapping(value = "/updateperson", method = RequestMethod.PUT )
    public String updatePerson(@RequestParam Integer id, Person person){
        personJPARepository.save(person);
        return "redirect:/";
    }    
    @RequestMapping(value = "/deleteperson", method = RequestMethod.DELETE )
    public String updatePerson(@RequestParam Integer id){
        personJPARepository.deleteById(id);
        return "redirect:/";
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