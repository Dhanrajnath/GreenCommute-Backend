package com.GreenCommute.Backend.Controller;


import com.GreenCommute.Backend.Entity.Jobs;
import com.GreenCommute.Backend.Helper.Helper;
import com.GreenCommute.Backend.Service.JobServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/jobs")
@CrossOrigin(origins = "*")
public class JobsController {

    @Autowired
    private JobServiceImpl jobService;

    @Autowired
    private Helper helper;

    @GetMapping
    public List<Jobs> getAllJobs(@RequestParam(value="location",required = false) String loc,@RequestParam(value="skill",required = false) String[] skill) {
        List<Jobs> jobsList = jobService.getAllJobs();
        if(loc==null && skill ==null){
            return jobsList;
        } else if (loc==null) {
         return helper.getJobsSearchBySkills(jobsList,skill);
        } else if (skill==null) {
            return jobService.getJobsSearchByLocation(loc);
        } else{
            List<Jobs> jobsByLoc =jobService.getJobsSearchByLocation(loc);
            return helper.getJobsSearchBySkills(jobsByLoc,skill);
        }
    }

    @GetMapping("/{id}")
    public Optional<Jobs> getJobById(@PathVariable(value="id") int id){
            return jobService.getJobById(id);
    }
}
