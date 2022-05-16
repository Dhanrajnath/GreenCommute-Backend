package com.greencommute.backend.serviceTests;

import com.greencommute.backend.entity.Jobs;
import com.greencommute.backend.entity.User;
import com.greencommute.backend.service.SavedJobServiceImpl;
import com.greencommute.backend.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Mock
    private UserServiceImpl userService;

    @Mock
    private SavedJobServiceImpl savedJobService;

    @Test
    public void getUserByIdTest(){
        int id=1;
        User user= new User(id,"user1",null);
        Optional<User> usersOptional = Optional.of(user);
        Mockito.when(userService.getUserById(id)).thenReturn(usersOptional);
        Assertions.assertEquals(usersOptional, userService.getUserById(id));
        Mockito.verify(userService).getUserById(id);
    }

    @Test
    public void saveJob() {
        int userId = 1;
        int jobId = 1;
        doNothing().when(savedJobService).saveToSavedJobs(userId,jobId);
        savedJobService.saveToSavedJobs(userId,jobId);
        Mockito.verify(savedJobService).saveToSavedJobs(userId,jobId);
    }

    @Test
    public void getSavedJobTest() {
        List<Jobs> jobsList = Collections.emptyList();
        List<Jobs> savedJob = savedJobService.getSavedJobsByUserID(1);
        Mockito.when(savedJobService.getSavedJobsByUserID(1)).thenReturn(jobsList);
        Assertions.assertEquals(jobsList, savedJob);
        Mockito.verify(savedJobService).getSavedJobsByUserID(1);
    }

}
