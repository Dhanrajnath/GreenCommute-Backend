package com.greencommute.backend.dtoTests;

import com.greencommute.backend.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDtoTests {

    UserDto userDto = new UserDto(1,"userDTO");
    UserDto userDto1 = new UserDto();

    @Test
    void userDtoEntityTest(){
        Assertions.assertEquals(1,userDto.getUserId());
        Assertions.assertEquals("userDTO",userDto.getUserName());

        userDto1.setUserName("user2");
        userDto1.setUserId(2);

        Assertions.assertEquals(2,userDto1.getUserId());
        Assertions.assertEquals("user2",userDto1.getUserName());

        Assertions.assertEquals("UserDto(userId=2, userName=user2)",userDto1.toString());
    }
}
