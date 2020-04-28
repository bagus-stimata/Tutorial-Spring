package com.example.springbootsecurity2mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

 
    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mas Kirun") String name, Model uiModel) {
        uiModel.addAttribute("name", name);
        int umur = 20;
        uiModel.addAttribute("umur", umur);

		return "greeting";
	}
}