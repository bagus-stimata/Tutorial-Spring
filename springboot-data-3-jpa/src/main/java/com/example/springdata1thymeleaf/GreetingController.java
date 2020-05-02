package com.example.springdata1thymeleaf;

import java.util.ArrayList;
import java.util.List;

import com.example.springdata1thymeleaf.jpa_repository.PersonJPARepository;
import com.example.springdata1thymeleaf.model.Person;
import com.example.springdata1thymeleaf.model.Todo;
import com.example.springdata1thymeleaf.repository.PersonJDBCRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private PersonJPARepository personJPARepository;

    @Autowired
    private PersonJDBCRepository personJDBCRepository;

    @GetMapping("/greeting_view")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mas Kirun") String name, Model uiModel) {
        
          
        List<Person> list = new ArrayList<>();
        list = personJPARepository.findAll();
        
        String nama = "";
        String todos = "";
        int counter =0;
        int counterTodo =0;
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            for (Todo detilItem: domain.getTodos()) {
                todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
                System.out.println(detilItem.getDescription());
            }
        }
        list = new ArrayList<>();
        list.add(personJPARepository.findByID(2));
        nama += " ######### AUTOMATIC JPQL ############ ";
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            for (Todo detilItem: domain.getTodos()) {
                todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
                System.out.println(detilItem.getDescription());
            }
        }


        list = new ArrayList<>();
        list = personJDBCRepository.findAll();
        nama += " ######### JDBC BIASA############ ";
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            // for (Todo detilItem: domain.getTodos()) {
            //     todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
            //     System.out.println(detilItem.getDescription());
            // }
        }

        list = new ArrayList<>();
        list = personJPARepository.findAllActivePerson();
        nama += " ######### Active Person JPQL ############ ";
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            for (Todo detilItem: domain.getTodos()) {
                todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
                System.out.println(detilItem.getDescription());
            }
        }

        list = new ArrayList<>();
        list = personJPARepository.findAllActivePersonNative();
        nama += " ######### Active Person Native ############ ";
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            for (Todo detilItem: domain.getTodos()) {
                todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
                System.out.println(detilItem.getDescription());
            }
        }

        list = new ArrayList<>();
        list.add(personJPARepository.findUserByNameAndAddress("%B%", "%") );
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            for (Todo detilItem: domain.getTodos()) {
                todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
                System.out.println(detilItem.getDescription());
            }
        }

        list = new ArrayList<>();
        list.add(personJPARepository.findUserByNameAndAddress_NamedParam("%Ty%", "%") );
        for (Person domain: list ){
            nama += ++counter+ ". " + domain.getName() + " (" + domain.getAddress() + ") => ";
           
            for (Todo detilItem: domain.getTodos()) {
                todos += ++counterTodo+ ". " + detilItem.getDescription() + "\t"; 
                System.out.println(detilItem.getDescription());
            }
        }

        uiModel.addAttribute("name", nama);
        uiModel.addAttribute("todos", todos); 

        /*
        Return ini adalah merupakan nama file yang ada di resource
        biasanay di bawah resource/template : oleh karena standart struktur dari thy
        */
		return "template_greeting"; 
    }
    

}