package com.example.springbootsecurity1basic.main_controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @GetMapping("/")
    // @ResponseBody //supaya tidak memerlukan homeIndex.html -> Jadi sperti rest
    public String index(){
        return "index";
    }
    @GetMapping("/home")
    // @ResponseBody //supaya tidak memerlukan homeIndex.html -> Jadi sperti rest
    public String homeIndex(){
        return "index";
    }

    @GetMapping("/admin")
    // @ResponseBody //supaya tidak memerlukan homeIndex.html -> Jadi sperti rest
    public String adminPage(){
        return "admin_page";
    }
    @GetMapping("/user")
    public String userPage(){
        return "user_page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //@PreAuthorize("hasRole('ADMIN_ROLE')")
    @GetMapping("/test")
    @ResponseBody
    public String testPage(){
        
        return "Secure Page: Tes Page<br> try to activate @EnableGlobalMethodSecurity(prePostEnabled = true) and @PreAuthorize ";
    }


    //Sama Access Denied dan Restricted
    @RequestMapping("/restricted")  
    @ResponseBody
    public String restricted(){
        return "The Page is Restricted";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}