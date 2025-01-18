package com.SecurityApp.Auth.Security.Repository;

import com.SecurityApp.Auth.Security.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

}
