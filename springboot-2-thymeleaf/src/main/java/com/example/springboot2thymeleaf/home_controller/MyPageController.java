package com.example.springboot2thymeleaf.home_controller;

import com.example.springboot2thymeleaf.model.Foo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyPageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/homePage")
	public String homePage(@RequestParam(name="name", required=false, defaultValue="-- Masukkan Nama --") String name, Model uiModel) {
        uiModel.addAttribute("name", name);

        /*
        Return ini adalah merupakan nama file yang ada di resource
        biasanay di bawah resource/template : oleh karena standart struktur dari thy
        */
		return "template_home"; 
    }
    @GetMapping(path = "/homePage_2")
    public String homePage_2(){
        return "template_home";
    }


    @RequestMapping( value = "/adminPage",  method=RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("name", "Nilai Biasa"); //Harus menggunakan: method=RequestMethod.GET
        modelAndView.setViewName("template_admin");
        
        return modelAndView;
    }

    //call with: http://localhost:8081/adminPage/Bagus Winarno Ganteng
    @RequestMapping( value = "/adminPage/{user_id}",  method=RequestMethod.GET)
    public ModelAndView adminPage_withPath(@PathVariable String user_id){
        ModelAndView modelAndView = new ModelAndView(); 

        modelAndView.addObject("name", user_id);

        modelAndView.setViewName("template_admin");
        
        return modelAndView;
    }

    /*
    Lebih Flexible dari yang atas
    */
    @RequestMapping( "/userPage")
    public String userPage(Model uiModel){
        uiModel.addAttribute("name", "User Page Pertama");

        Foo foo = new Foo(1, "Ken Arok");
        uiModel.addAttribute("foo", foo);

        return "template_user";
    }
    @RequestMapping( value = "/userPage_2", method=RequestMethod.GET)
    public String userPage_2(Model uiModel){
        
        uiModel.addAttribute("name", "User Page 2");

        return "template_user";
    }
    
    
}