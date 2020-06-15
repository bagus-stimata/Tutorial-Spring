package com.example.springbootrest3security.main_controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String homeIndex(Model viewModel){
        /**
         * Menampilkan user dengan berbagai cara
         */
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String namaUser = auth.getName(); //jika tidak ada akan memberikan nilai null
        String principal_1 = auth.getPrincipal().toString();
        viewModel.addAttribute("namaUser", namaUser);
        viewModel.addAttribute("principal", principal_1);

        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }      

        viewModel.addAttribute("userName", userName);
  

        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-view")
    // @ResponseBody //supaya tidak memerlukan homeIndex.html -> Jadi sperti rest
    public String adminPage(){
        return "admin_page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //Sama Access Denied dan Restricted
    @RequestMapping("/restricted")  
    @ResponseBody
    public String restricted(){
        return "The Page is Restricted";
    }



}