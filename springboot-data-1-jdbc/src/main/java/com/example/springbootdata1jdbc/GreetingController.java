package com.example.springbootdata1jdbc;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

     @GetMapping("/greeting_view")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mas Kirun") String name, Model uiModel) {
        
        String nama = "";
        String todos = "";

        uiModel.addAttribute("name", nama);
        uiModel.addAttribute("todos", todos); 

        /*
        Return ini adalah merupakan nama file yang ada di resource
        biasanay di bawah resource/template : oleh karena standart struktur dari thy
        */
		return "template_greeting"; 
    }
    

}