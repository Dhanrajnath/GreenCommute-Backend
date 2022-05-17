package com.greencommute.backend;

import com.greencommute.backend.entity.Jobs;
import com.greencommute.backend.service.JobService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class JobTests {

    @Mock
    private JobService jobService;

    @Test
    void getJobByIdTest() {
        int id = 1;
        Jobs job = new Jobs(1,"Software Engineer","Developer","Hyderabad",null,null);
        Optional<Jobs> jobsOptional = Optional.of(job);
        Mockito.when(jobService.getJobById(id)).thenReturn(jobsOptional);
        Assertions.assertEquals(jobsOptional, jobService.getJobById(id));
        Mockito.verify(jobService).getJobById(id);
    }

    @Test
    void getAllJobsTest() {
        List<Jobs> jobsList = Collections.emptyList();
        List<Jobs> jobs = jobService.getAllJobs();
        Mockito.when(jobService.getAllJobs()).thenReturn(jobsList);
        Assertions.assertEquals(jobsList, jobs);
        Mockito.verify(jobService).getAllJobs();
    }
}
