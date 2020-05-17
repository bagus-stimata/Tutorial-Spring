package com.example.springbootsecurity2withdb.web_controller;

import com.example.springbootsecurity2withdb.model.Role;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Root(){
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeIndex(Model viewModel){
      
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth !=null) {
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
        }

        return "index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "/login-form/login";
    }
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/login-error/access-denied";
    }
    
    /**
     * Otomatis dibaca:
     *  ROLE_ADMIN, ROLE_USER, ROLE_ACCOUNTING
     */

    @PreAuthorize("hasRole('" + Role.ADMIN + "')") 
    // @PreAuthorize("hasRole('ADMIN')") 
    @GetMapping(value = "/admin/index")
    public String Admin(){
        return "/admin/index";
    }
    @PreAuthorize("hasRole('" + Role.ACCOUNTING + "')") 
    @RequestMapping(value = "/accounting/index", method = RequestMethod.GET)
    public String Accounting(){
        return "/accounting/index";
    }

    @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = "/profile/index", method = RequestMethod.GET)
    public String Profile(){
        return "/profile/index";
    }

}