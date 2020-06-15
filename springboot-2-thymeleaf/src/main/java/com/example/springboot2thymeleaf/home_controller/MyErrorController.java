package com.example.springboot2thymeleaf.home_controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller 
public class MyErrorController implements ErrorController{

    @Override
    public String getErrorPath() {        
        return "/error";
    }

    // @GetMapping("/error")
    // public String handleError() {
    //     //do something like logging
    //     return "error_page";
    // }
 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
       
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
        
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error_page_400";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error_page_500";
            }
        }

        return "error_page";
    }


}