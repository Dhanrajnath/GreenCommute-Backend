package com.greencommute.backend.serviceTests;

import com.greencommute.backend.entity.Jobs;
import com.greencommute.backend.entity.SavedJobs;
import com.greencommute.backend.entity.User;
import com.greencommute.backend.repository.SavedJobsJpa;
import com.greencommute.backend.repository.UserJpa;
import com.greencommute.backend.service.SavedJobService;
import com.greencommute.backend.service.SavedJobServiceImpl;
import com.greencommute.backend.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SavedJobTests {

    @Mock
    private SavedJobService savedJobService;

    @Mock
    private SavedJobsJpa savedJobsJpa;

    @BeforeEach
    void initUseCase(){
        savedJobService = new SavedJobServiceImpl(savedJobsJpa);
    }

    @Test
    public void saveJob() {
//        User user = new User(1, "Dhanrajnath", null);
//        Jobs job = new Jobs(1,"Software Engineer","Developer","Hyderabad",null,null);
//        SavedJobs savedJob = new SavedJobs(new Timestamp(System.currentTimeMillis()),user,job);
//        doNothing().when(savedJobService).saveToSavedJobs(1,1);
//        Mockito.verify(savedJobsJpa).findById(1);
    }

    @Test
    public void getSavedJobTest() {
        Jobs job = new Jobs(1,"Software Engineer","Developer","Hyderabad",null,null);
        List<Jobs> savedJob = new ArrayList<>();
        savedJob.add(job);
        Mockito.when(savedJobService.getSavedJobsByUserID(1)).thenReturn(savedJob);
        Assertions.assertEquals(savedJob, savedJobService.getSavedJobsByUserID(1));
        Mockito.verify(savedJobService).getSavedJobsByUserID(1);
    }

    @Test
    public void deleteSavedJobTest() {
        Jobs job = new Jobs(1,"Software Engineer","Developer","Hyderabad",null,null);
        List<Jobs> savedJob = new ArrayList<>();
        savedJob.add(job);
        boolean res=true;
        Mockito.when(savedJobService.deleteSavedJobs(1,1)).thenReturn(res);
        savedJob.remove(0);
        Assertions.assertEquals(savedJob, savedJobService.getSavedJobsByUserID(1));
        Assertions.assertEquals(savedJobService.deleteSavedJobs(1,2),false);
    }

}
