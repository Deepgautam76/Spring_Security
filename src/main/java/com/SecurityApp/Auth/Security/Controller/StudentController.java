package com.SecurityApp.Auth.Security.Controller;

import com.SecurityApp.Auth.Security.Model.Student;
import com.SecurityApp.Auth.Security.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * These all end points are protected
 */
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<?>> getStudents(){
        List<Student> allStudent=studentService.getStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent=studentService.creteStudent(student);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }

}
