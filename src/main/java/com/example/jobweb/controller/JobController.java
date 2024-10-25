package com.example.jobweb.controller;

import com.example.jobweb.entity.JobPost;
import com.example.jobweb.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobServices jobServices;


    @GetMapping("/jobs")
    public ResponseEntity<List<JobPost>> getAllJobs() {
        return new ResponseEntity<>(jobServices.getAlljobs(),HttpStatus.OK);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<JobPost> getJobById(@PathVariable int id) {
        return new ResponseEntity<>(jobServices.getJobByid(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<JobPost> saveJob(@RequestBody JobPost jobPost){
        return new ResponseEntity<>(jobServices.saveJob(jobPost), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody JobPost jobPost) {
        if(jobServices.updateJob(id,jobPost)){
           return new  ResponseEntity<>("Job post successfully update", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Job post not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        if(jobServices.deleteJob(id)){
            return new  ResponseEntity<>("Job post deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Job post not found", HttpStatus.NOT_FOUND);
        }
    }
}
