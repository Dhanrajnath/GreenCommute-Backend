package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.Jobs;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Optional<Jobs> getJobById(int id);

    List<Jobs> getAllJobs();

    List<Jobs> getJobsSearchByLocation(String location);
}
