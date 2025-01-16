package com.SecurityApp.Auth.Security.Service;


import com.SecurityApp.Auth.Security.Model.Users;
import com.SecurityApp.Auth.Security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=userRepo.findByUsername(username);

        System.out.println("User:" +user);
        if(user==null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not found in database");
        }
        return new UserPrincipal(user);
    }
}
