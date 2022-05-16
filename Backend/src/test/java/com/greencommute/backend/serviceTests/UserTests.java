package com.greencommute.backend.serviceTests;

import com.greencommute.backend.entity.User;
import com.greencommute.backend.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Mock
    private UserServiceImpl userService;


    @Test
    public void getUserByIdTest(){
        int id=1;
        User user= new User(id,"user1",null);
        Optional<User> usersOptional = Optional.of(user);
        Mockito.when(userService.getUserById(id)).thenReturn(usersOptional);
        Assertions.assertEquals(usersOptional, userService.getUserById(id));
        Mockito.verify(userService).getUserById(id);
    }

}
