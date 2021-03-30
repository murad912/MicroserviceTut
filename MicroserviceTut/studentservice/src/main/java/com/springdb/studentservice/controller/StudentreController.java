package com.springdb.studentservice.controller;



import com.springdb.studentservice.model.Student;
import com.springdb.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public Student add(@RequestBody Student s){
        return service.add(s);
    }

    @GetMapping("/{id}")
    public Student getStuden(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping()
    public List<Student> getStudent(){
        return service.getAllStudent();
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student s, @PathVariable("id") Long id){
        return service.update(s,id);
    }

}
