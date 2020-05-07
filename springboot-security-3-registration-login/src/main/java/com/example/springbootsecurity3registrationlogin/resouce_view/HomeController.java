package com.example.springbootsecurity3registrationlogin.resouce_view;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome_page"); //Mengacu pada  welcome_page.html
        return model;
    }   

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome_page");
        return model;

    }

    @RequestMapping(value = { "/adminPage"}, method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome_page");
        return model;

    }

    @RequestMapping(value = { "/userPage"}, method = RequestMethod.GET)
    public ModelAndView userPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome_page");
        return model;

    }


    @RequestMapping(value = { "/loginPage"}, method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout ){
        ModelAndView model = new ModelAndView();

        if (error !=null) {
            model.addObject("error", "Invalid Creditiona Provided");
        }
        if (logout !=null){
            model.addObject("message", "Logged out From Bagus Winarno's Web");
        }

        model.setViewName("loginPage");
        return model;

    }

 

}