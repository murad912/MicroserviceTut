package com.springdemo.main.Controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springdemo.main.DTO.Job;
import com.springdemo.main.DTO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/central")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${studenturl}")
    String studentUrl;
    @Value("${joburl}")
    String jobUrl;



    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student s){

        //external configuration file with @value option for calling service by name
        Student student = restTemplate.postForObject("http://" + studentUrl + "/students/" + "add" , s , Student.class); //post url + obj + class
        //basic option for calling service by name
        //Student student = restTemplate.postForObject("http://StudentService/students" + "add" , s , Student.class);
        return student;

    }

    @PostMapping("/addstudentjob/{id}")
    public Job addStudenJob(@PathVariable("id") Long id, @RequestBody Job j){
        Student s = restTemplate.getForObject("http://" + studentUrl + "/students/"+ id, Student.class ); //get url and class
        if(s==null){
            return null;
        }else{
            j.setStudid(id);
            Job job = restTemplate.postForObject("http://" +jobUrl + "/jobs/" + "add", j, Job.class);
            return  job;
        }

    }

    @GetMapping("/getstudent/{id}")
    @HystrixCommand
    public Student getStudent(@PathVariable("id") Long id){
        Student s = restTemplate.getForObject("http://" + studentUrl + "/students/"+ id, Student.class );
        if(s==null){
            return null;
        }
        return s;
    }
    @GetMapping("/getstudentjob/{id}")
    public List<Job> getStudentJob(@PathVariable("id") Long id){
        List<Job> j = restTemplate.getForObject("http://" + jobUrl+ "/jobs/" + "getbystudentid/" + id, List.class);
        if(j==null){
            return null;
        }
        return j;
    }

    @GetMapping("/getallstudents")
    public List<Student> getAllStudent(){
        List<Student> s = restTemplate.getForObject("http://" + studentUrl+ "/students", List.class);
        return s;
    }

    @GetMapping("/getalljobs")
    @HystrixCommand(fallbackMethod = "fallbackDefault")
    public List<Job> getAllJob(){
        List<Job>j = restTemplate.getForObject("http://" + jobUrl+ "/jobs", List.class);
        return j;
    }

    public List<Job> fallbackDefault(){
        return Arrays.asList(new Job("No company", "No status",0));
    }

}
