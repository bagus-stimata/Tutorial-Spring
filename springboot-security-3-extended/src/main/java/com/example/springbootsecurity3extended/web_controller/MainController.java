package com.example.springbootsecurity3extended.web_controller;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootsecurity3extended.SecurityConfig.PassEncoding;
import com.example.springbootsecurity3extended.jpa_repository.UserRolesRepository;
import com.example.springbootsecurity3extended.jpa_repository.UsersRepository;
import com.example.springbootsecurity3extended.model.FUser;
import com.example.springbootsecurity3extended.model.FUserRoles;
import com.example.springbootsecurity3extended.model.Role;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Root(){
        return "index";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeIndex(Model viewModel){

        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // String namaUser = auth.getName(); //jika tidak ada akan memberikan nilai null
        // String principal_1 = auth.getPrincipal().toString();
        // viewModel.addAttribute("namaUser", namaUser);
        // viewModel.addAttribute("principal", principal_1);

        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        logger.info("#Form Login");
        // return "/login-form/login_old";
        return "/login-form/login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("reqUser", new FUser() );
        logger.info("#Form Register");
        return "/login-form/register";
    }    

    @RequestMapping(value = {"/register/register_proses"}, method = RequestMethod.POST)
    public String register(@ModelAttribute("reqUser") FUser reqUser,
                           final RedirectAttributes redirectAttributes) {

        logger.info("#/user/register_proses");
        
        FUser user = usersRepository.findByUsername(reqUser.getUsername() );
        if (user != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-name");
            return "redirect:/register";
        }

        user = usersRepository.findByEmail(reqUser.getEmail());
        if (user != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-email");
            return "redirect:/register";
        }

        reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword() ));
        List<FUserRoles> listFUserLRoles = new ArrayList<>();
        FUserRoles userRole1 = new FUserRoles();
        userRole1.setFuserBean(reqUser);
        userRole1.setRoleID(Role.USER);
        FUserRoles userRole2 = new FUserRoles();
        userRole2.setFuserBean(reqUser);
        userRole2.setRoleID(Role.ADMIN);

        listFUserLRoles.add(userRole1);
        listFUserLRoles.add(userRole2);

        reqUser.setFuserRoles(listFUserLRoles);

        if (usersRepository.save(reqUser) != null) {
            
            if (userRolesRepository.save(userRole1) !=null &&  
                userRolesRepository.save(userRole2) !=null) {

                redirectAttributes.addFlashAttribute("saveUser", "success");
            }


        } else {
            redirectAttributes.addFlashAttribute("saveUser", "fail");
        }

        return "redirect:/register";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/login-error/access-denied";
    }
        
    @PreAuthorize("hasRole('" + Role.ADMIN + "')") 
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