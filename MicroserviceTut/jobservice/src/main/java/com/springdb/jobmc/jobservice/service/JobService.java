package com.springdb.jobmc.jobservice.service;


import com.springdb.jobmc.jobservice.model.Job;
import com.springdb.jobmc.jobservice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public Job add(Job s){
        return repo.save(s);
    }

    public List<Job> getAllJob(){
        return repo.findAll();
    }

    public Job getById(Long id){
        return repo.findById(id).get();
    }

    public List<Job> getByStudentId(Long id){
        return repo.findByStudid(id);
    }

    public String deleteById(Long id){
        repo.deleteById(id);
        return "Sucessfully Deleted";
    }

    public Job update(Job s, Long id){
        s.setId(id);

        return repo.save(s);
    }
}
