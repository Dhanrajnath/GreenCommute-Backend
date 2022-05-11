package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.Jobs;
import com.GreenCommute.Backend.JPARepository.JobsJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobsJpa jobsJpa;

    @Override
    public Optional<Jobs> getJobById(int id) {
        return jobsJpa.findById(id);
    }

    @Override
    public List<Jobs> getAllJobs() {
        return jobsJpa.findAll();
    }

    @Override
    public List<Jobs> getJobsSearchByLocation(String location){
        return jobsJpa.getJobsByLocation(location);
    }
}
