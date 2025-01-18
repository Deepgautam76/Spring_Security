package com.SecurityApp.Auth.Security.ConfigService;


import com.SecurityApp.Auth.Security.Model.Users;
import com.SecurityApp.Auth.Security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * MyUserDetailsService class Implement the UserDetailsService
 * Interface to override the loadUserByUserName method
 * To fetching the user from a database.
 * If the user exists, then call the
 * "UserPrincipal"(UserPrincipal is the custom class for implementing the UserDetails Interface)
 * And pass the fetched user form DB
 */
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
