package com.SecurityApp.Auth.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to security zone:"+request.getSession().getId();
    }
}
