package com.SecurityApp.Auth.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * These are the public urls
 */
@RestController
public class HomeController {
    @GetMapping("/home")
    public String Home(){
        return "Welcome to the Security Home controller zone";
    }
    @GetMapping("/session")
    public String sessionId(HttpServletRequest request){
        return "Welcome to security zone:"+request.getSession().getId();
    }
}
