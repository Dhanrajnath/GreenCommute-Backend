package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.User;
import com.GreenCommute.Backend.JPARepository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpa userJpa;

    @Override
    public Optional<User> getUserById(int userId) {
        return userJpa.findById(userId);
    }
}