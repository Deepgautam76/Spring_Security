package com.SecurityApp.Auth.Security.Controller;

import com.SecurityApp.Auth.Security.Model.Users;
import com.SecurityApp.Auth.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This end-point protected
     */
    @GetMapping("/api/v1/users")
    public ResponseEntity<?> getAllUser(){
        List<Users> user=userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * This end-pont public
     */
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody Users user){
        System.out.println("Upcoming the body"+ user);
        Users CreatedUser=userService.createUser(user);
        System.out.println("After save the user:"+CreatedUser);
        return new ResponseEntity<>(CreatedUser,HttpStatus.CREATED);
    }

}
