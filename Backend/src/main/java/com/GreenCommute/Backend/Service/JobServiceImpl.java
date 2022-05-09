package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.Jobs;
import com.GreenCommute.Backend.JPARepository.JobsJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl {
    @Autowired
    private JobsJpa jobsJpa;

    public Optional<Jobs> getJobById(int id) {
        return jobsJpa.findById(id);
    }

    public List<Jobs> getAllJobs() {
        return jobsJpa.findAll();
    }

    public List<Jobs> getJobsSearchByLocation(String location){
        return jobsJpa.getJobsByLocation(location);
    }
}
