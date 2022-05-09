package com.GreenCommute.Backend.Controller;

import com.GreenCommute.Backend.Entity.User;
import com.GreenCommute.Backend.Service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String getUser() {
        return "User-1";
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") int id) {
        return userService.getUserById(id);
    }
}