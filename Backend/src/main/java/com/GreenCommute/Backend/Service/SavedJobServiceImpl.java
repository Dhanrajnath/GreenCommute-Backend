package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.Jobs;
import com.GreenCommute.Backend.Entity.SavedJobs;
import com.GreenCommute.Backend.Entity.User;
import com.GreenCommute.Backend.JPARepository.SavedJobsJpa;
import com.GreenCommute.Backend.JPARepository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SavedJobServiceImpl implements  SavedJobService{

    @Autowired
    UserJpa userJpa;

    @Autowired
    UserService userService;

    @Autowired
    JobService jobService;
    @Autowired
    SavedJobsJpa savedJobsJpa;

    @Override
    public String saveToSavedJobs(int userId, int jobId) {
    Optional<User> user = userService.getUserById(userId);
    Optional<Jobs> jobs = jobService.getJobById(jobId);
    SavedJobs savedJobs=new SavedJobs(new Timestamp(System.currentTimeMillis()),user.get(),jobs.get());
    savedJobsJpa.save(savedJobs);
        return "job id: "+jobId+" saved for user with id: "+userId;
    }

    @Override
    public List<Jobs> getSavedJobsByUserID(int userId) {
        Optional<User> user = userJpa.findById(userId);
        List<Jobs> jobList = new ArrayList<>();
        List<SavedJobs> savedJobsList =user.get().getSavedJobsList();
        for (SavedJobs savedJobs: savedJobsList) {
            jobList.add(savedJobs.getJobs());
        }
        return jobList;
    }

    @Override
    public void deleteSavedJobs(int savedJobId) {
       Optional<SavedJobs> savedJobs = savedJobsJpa.findById(savedJobId);
       savedJobsJpa.delete(savedJobs.get());
    }
}
