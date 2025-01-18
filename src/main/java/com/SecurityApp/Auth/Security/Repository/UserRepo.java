package com.SecurityApp.Auth.Security.Repository;

import com.SecurityApp.Auth.Security.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
