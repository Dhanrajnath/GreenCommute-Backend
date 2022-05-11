package com.GreenCommute.Backend.Controller;


import com.GreenCommute.Backend.Entity.Jobs;
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

    @GetMapping
    public List<Jobs> getAllJobs(@RequestParam(value="location",required = false) String loc) {
        if(loc==null){
            return jobService.getAllJobs();
        }
        else{
            return jobService.getJobsSearchByLocation(loc);
        }
    }

    @GetMapping("/{id}")
    public Optional<Jobs> getJobById(@PathVariable(value="id") int id){
            return jobService.getJobById(id);
    }
}
