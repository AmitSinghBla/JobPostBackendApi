package com.example.jobweb.services;

import com.example.jobweb.JobwebApplication;
import com.example.jobweb.entity.JobPost;
import com.example.jobweb.repositories.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServices {
    @Autowired
    JobPostRepo jobPostRepo;

    public List<JobPost> getAlljobs() {
        return jobPostRepo.findAll();
    }

    public JobPost saveJob(JobPost jobPost) {
        return jobPostRepo.save(jobPost);
    }

    public boolean updateJob(int id, JobPost jobPost) {
        Optional<JobPost> existingJob = jobPostRepo.findById(id);
        if(existingJob.isPresent()){
            JobPost jobToUpdate = existingJob.get();
            jobToUpdate.setJobTitle(jobPost.getJobTitle());
            jobToUpdate.setDescription(jobPost.getDescription());
            jobToUpdate.setExperience(jobPost.getExperience());
            jobToUpdate.setLocation(jobPost.getLocation());
            jobPostRepo.save(jobToUpdate);
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteJob(int id) {
        Optional<JobPost> existingJob = jobPostRepo.findById(id);
        if(existingJob.isPresent()){
            JobPost jobToDelete = existingJob.get();
            jobPostRepo.delete(jobToDelete);
            return true;
        }else {
            return false;
        }
    }

    public JobPost getJobByid(int id) {
        Optional<JobPost> existingJob = jobPostRepo.findById(id);
        return existingJob.get();
    }
}
