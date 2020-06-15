package com.example.springboot2thymeleaf.rest_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.springboot2thymeleaf.model.SampleCheckboxes;
import com.example.springboot2thymeleaf.model.EnumRole;
import com.example.springboot2thymeleaf.model.Role;
import com.example.springboot2thymeleaf.model.SampleUser;
import com.example.springboot2thymeleaf.model.SampleUserRole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyFormController {
    
    Logger log = LoggerFactory.getLogger(MyFormController.class);

    @ModelAttribute("allEnumRoles")
    public EnumRole[] getAllEnumRoles() {
        return EnumRole.values();
    }
    @ModelAttribute("allRoles")
    public String[] getAllRoles() {
        return Role.getAllRoles();
    }

    @ModelAttribute("allUserRoles")
    public List<SampleUserRole> getListUserRoles() {
        List<SampleUserRole> list = new ArrayList<>();
        int counter =1;
        for (EnumRole enumRole: EnumRole.values()) {
            SampleUserRole sampleUserRole = new SampleUserRole();
            sampleUserRole.setId(counter++);
            sampleUserRole.setEnumRole(enumRole);
            sampleUserRole.setSampleUserBean(new SampleUser());

            list.add(sampleUserRole);
        }

     

        return list;
    }

    @ModelAttribute("mapRoles")
    public Map<Integer, String> getMapRoles() {
        Map<Integer, String> map = new HashMap<>();

        int counter =1;
        for (String role: Role.getAllRoles()  ) {            
            map.put(counter++, role);
        }

        return map;
    }


    @ModelAttribute("listEnumRoles")
    public List<EnumRole> getListEnumRoles() {
        return Arrays.asList(EnumRole.values());
    }


    @GetMapping("/sampleDropdowns")
    public String sampleDropdowns(Model model) {


        model.addAttribute("sampleUser", new SampleUser());

        model.addAttribute("message", "Awalnya");
    

        return "sampleDropdowns";
    }

    // @PostMapping("/sampleDropdowns")
    // public String saveSampleDropdowns(SampleUser fuser,  @RequestAttribute("multi_select_1") String multi_select_1,
    //                                BindingResult bindingResult, Model model) {
    //     log.info("command object = {}", fuser);


    //     model.addAttribute("message", fuser);
    //     // model.addAttribute("message2", multi_select_1);
       

    //     return "sampleDropdowns";
    // }


    @PostMapping("/sampleDropdowns")
    public String saveSampleDropdowns(@ModelAttribute("sampleUser") SampleUser fuser,  
                                   BindingResult bindingResult, Model model) {


        log.info("command object = {}", fuser);

        model.addAttribute("message", fuser);
        // model.addAttribute("message2", multi_select_1);
       

        return "sampleDropdowns";
    }


   

}