package com.example.springbootsecurity3extended.web_controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.example.springbootsecurity3extended.jpa_repository.AktifitasJPARepository;
import com.example.springbootsecurity3extended.jpa_repository.PersonJPARepository;
import com.example.springbootsecurity3extended.jpa_repository.TodoJPARepository;
import com.example.springbootsecurity3extended.model.Aktifitas;
import com.example.springbootsecurity3extended.model.Employee;
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
public class MainRestController {
    
    private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

    @Autowired
    PersonJPARepository personJPARepository;

    @Autowired
    TodoJPARepository todoJPARepository;
    @Autowired
    AktifitasJPARepository aktifitasJPARepository;


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
    @RequestMapping(value = "/getmessage", produces = "application/json")
	public Message getMessage(){
		return new Message(100, "Congratulations!", "You have accessed a Basic Auth protected resource.");
	}



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

    // @RequestMapping(value = "/createperson", method = RequestMethod.POST)
    // public String createPerson(){
    //     // personJPARepository.save(person);
    //     logger.debug("Hello ini dipanggil");
    //     // return new Person();
    //     return "redirect:/";
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