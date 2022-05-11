package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(int userId);
}
