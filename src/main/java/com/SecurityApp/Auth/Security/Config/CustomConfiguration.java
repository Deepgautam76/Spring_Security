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

    /**
     * Fist any request comes
     * That is hit to the SecurityFilterChain
     * Then apply the filter "UserNamePasswordAuthenticationFilter"
     * This filter extracts the Username and password
     * And load them into the security context
     * To verify the UserName and Password.
     * That load by the "UserDetailsService" in to security context
     * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(custmizer->custmizer.disable())
                .sessionManagement(management->management
                          .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request->request
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /**
     *  This is CustomAuthentication provider
     *  Take the username from security context
     *  Use the "UserDetailsService Interface" to loadUserByUserName
     *  If a user exists, then set user and password in AuthenticationManager
     *  To verify the user and password that the user sends in request.
     */

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

}
