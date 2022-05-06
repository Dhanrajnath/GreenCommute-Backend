package com.GreenCommute.Backend.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "User-1";
    }
}