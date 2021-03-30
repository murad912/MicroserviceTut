package com.springdb.jobmc.jobservice.controller;


import com.springdb.jobmc.jobservice.model.Job;
import com.springdb.jobmc.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
class JobController {

    @Autowired
    private JobService service;

    @PostMapping("/add")
    public Job add(@RequestBody Job s){
        return service.add(s);
    }

    @GetMapping("getbystudentid/{id}")
    public List<Job> getStudenId(@PathVariable("id") Long id){
        return service.getByStudentId(id);
    }

    @GetMapping()
    public List<Job> getStuden(){
        return service.getAllJob();
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Job update(@RequestBody Job s, @PathVariable("id") Long id){
        return service.update(s,id);
    }

}
