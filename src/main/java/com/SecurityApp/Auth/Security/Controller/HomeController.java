package com.SecurityApp.Auth.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * These are the public urls
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String Home(){
        return "Welcome to the Security Zone .....!";
    }
    @GetMapping("/session")
    public String sessionId(HttpServletRequest request){
        return "Welcome to security zone:"+request.getSession().getId();
    }
    @GetMapping("/csrf")
    public String  csrfToken(HttpServletRequest request){
        CsrfToken csrf= (CsrfToken) request.getAttribute("_csrf");
        return "CSRF Token is: "+csrf;
    }
}
