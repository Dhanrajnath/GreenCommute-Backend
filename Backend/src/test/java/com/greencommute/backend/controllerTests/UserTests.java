package com.greencommute.backend.controllerTests;

import com.greencommute.backend.controller.UserController;
import com.greencommute.backend.dto.UserDto;
import com.greencommute.backend.entity.User;
import com.greencommute.backend.mapper.UserMapper;
import com.greencommute.backend.mapper.UserMapperImpl;
import com.greencommute.backend.service.UserService;
import com.greencommute.backend.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @InjectMocks
    UserController userController;

    @Mock
    UserServiceImpl userService;

    @Mock
    UserMapper userMapper;


    @Test
    public void getUserByIdTest(){
        User user = new User(1, "Dhanrajnath", null);
        UserDto userDto = userMapper.toUserDto(user);
        Mockito.when(userService.getUserById(1)).thenReturn(Optional.of(user));
        Assertions.assertEquals(ResponseEntity.ok().body(userDto),userController.getUserById(1));
        Mockito.verify(userService).getUserById(1);

    }
}
