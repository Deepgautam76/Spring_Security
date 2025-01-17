package com.SecurityApp.Auth.Security.Service;

import com.SecurityApp.Auth.Security.Model.Users;
import com.SecurityApp.Auth.Security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }
    public  Users createUser(Users user){
        Users newUser=new Users();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        return userRepo.save(newUser);
    }
}
