package com.springdb.jobmc.jobservice.repository;




import com.springdb.jobmc.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

     public List<Job> findByStudid(Long id); //custom repository method

}
