package com.example.springboot1bootstrapthymeleaf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
    private String appMode;

    @Autowired
    public WebAppController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date()) ;
        model.addAttribute("username", "Bagus Winarno");
        model.addAttribute("appMode", appMode);

        return "index";
    }


    @GetMapping
	public String page1() {
		return "page1";
	}
	
	@GetMapping("/page2")
	public String page2() {
		return "page2";
    }
    
}
