package com.SecurityApp.Auth.Security.Config;

import com.SecurityApp.Auth.Security.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomConfiguration {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(custmizer->custmizer.disable())
                .sessionManagement(management->management
                          .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request->request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();

//        //This is for browser provide the form login
//        http.formLogin(Customizer.withDefaults());
//        //This is for the REST client like Postman
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
    }

//
//    //Bean of the user detailed Service for customize the username and password
//    @Bean
//    public UserDetailsService userDetailsService(){
//        //That are the hardcoded username and password
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("Kamal")
//                .password("12345")
//                .roles("USER")
//                .build();
//        UserDetails user2= User
//                .withDefaultPasswordEncoder()
//                .username("Deep")
//                .password("12345")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }


    //This is provided username and password from a database
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

}
