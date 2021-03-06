package com.greencommute.backend.service;

import com.greencommute.backend.entity.Jobs;
import com.greencommute.backend.entity.SavedJobs;
import com.greencommute.backend.entity.User;
import com.greencommute.backend.repository.SavedJobsJpa;
import com.greencommute.backend.repository.UserJpa;
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
    public Boolean deleteSavedJobs(int userId,int jobId) {
       SavedJobs savedJob = savedJobsJpa.deleteByUserAndJobId(userId, jobId);
       if(savedJob == null){
           return false;
       }
       savedJobsJpa.delete(savedJob);
       return true;
    }
}
