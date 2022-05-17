package com.greencommute.backend.serviceTests;

import com.greencommute.backend.entity.User;
import com.greencommute.backend.repository.UserJpa;
import com.greencommute.backend.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    public UserJpa userJpa;

    @Test
    public void getUserByIdTest(){
        int id=1;
        Optional<User> user= Optional.of(new User(1, "user1", null));
        Mockito.when(userJpa.findById(1)).thenReturn(user);
        Assertions.assertEquals(user, userService.getUserById(id));
        Mockito.verify(userJpa).findById(id);
    }

}
