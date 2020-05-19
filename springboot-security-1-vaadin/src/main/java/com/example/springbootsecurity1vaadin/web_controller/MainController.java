package com.example.springbootsecurity1vaadin.web_controller;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootsecurity1vaadin.model.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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