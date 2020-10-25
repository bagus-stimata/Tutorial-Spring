package com.example.springbootsecurity1vaadin.web_controller;

import com.example.springbootsecurity1vaadin.security_model.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Pada framework vaadin Controller model semacam ini masih bisa berjalan baik
 *   @EnableGlobalMethodSecurity(prePostEnabled = true) pada SecurityConfiguration.java
 */
@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/login-error/access-denied";
    }
        
    @PreAuthorize("hasRole('" + Role.ADMIN + "')") 
    @GetMapping(value = "/admin/index")
    @ResponseBody
    public String Admin(){
        return "/admin/index";
    }

    @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    @ResponseBody
    public String User(){
        return "/user/index";
    }



}