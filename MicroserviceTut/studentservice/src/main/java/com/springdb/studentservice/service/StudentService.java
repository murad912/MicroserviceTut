package com.springdb.studentservice.service;

import com.springdb.studentservice.model.Student;
import com.springdb.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository repo;

    public Student add(Student s){
        return repo.save(s);
    }

    public List<Student> getAllStudent(){
        return repo.findAll();
    }

    public Student getById(Long id){
        return repo.findById(id).get();
    }

    public String deleteById(Long id){
        repo.deleteById(id);
        return "Sucessfully Deleted";
    }

    public Student update(Student s, Long id){
        s.setId(id);

        return repo.save(s);
    }
}
