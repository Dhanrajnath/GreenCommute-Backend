package com.GreenCommute.Backend.Controller;

import com.GreenCommute.Backend.Dto.UserDto;
import com.GreenCommute.Backend.Entity.Jobs;
import com.GreenCommute.Backend.Entity.User;
import com.GreenCommute.Backend.Mapper.UserMapper;
import com.GreenCommute.Backend.Service.SavedJobServiceImpl;
import com.GreenCommute.Backend.Service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SavedJobServiceImpl savedJobService;
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int id) {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok().body(user.get());
//        UserDto userDto = UserMapper.INSTANCE.toUserDto(user.get());
//        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/{id}/savedJobs")
    public List<Jobs> getSavedJobsOfUser(@PathVariable(value = "id") int id) {
        return savedJobService.getSavedJobsByUserID(id);
    }

    @PostMapping("/{id}/savedJobs")
    public String saveJobsForUser(@PathVariable(value = "id") int id,@RequestBody Map<String,Integer> reqPayload) {
        return savedJobService.saveToSavedJobs(id, reqPayload.get("jobId"));
    }

    @DeleteMapping("/{id}/savedJobs")
    public String deleteSavedJobsOfUser(@PathVariable(value="id") int id,@RequestBody Map<String,Integer> reqPayload){
        savedJobService.deleteSavedJobs(reqPayload.get("savedJobId"));
        return "saved job id: "+reqPayload.get("savedJobId")+" unsaved for user with id: "+id;
    }
}