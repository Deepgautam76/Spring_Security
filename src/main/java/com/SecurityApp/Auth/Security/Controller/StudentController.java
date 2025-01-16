package com.SecurityApp.Auth.Security.Controller;

import com.SecurityApp.Auth.Security.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"kamal",22),
            new Student(2,"deep",23),
            new Student(3,"Munna",22)
    ));

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> allUser(){
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken csrfToken(HttpServletRequest request){
        CsrfToken csrf= (CsrfToken) request.getSession().getAttribute("_csrf");
        return csrf;
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }


}