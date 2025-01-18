package com.SecurityApp.Auth.Security.Service;

import com.SecurityApp.Auth.Security.Model.Student;
import com.SecurityApp.Auth.Security.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

    public Student creteStudent(Student student){
        Student newStudent=new Student();
        newStudent.setId(student.getId());
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());

        return studentRepo.save(newStudent);
    }
}
