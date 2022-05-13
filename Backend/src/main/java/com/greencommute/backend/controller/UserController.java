package com.greencommute.backend.controller;

import com.greencommute.backend.dto.ResponseDto;
import com.greencommute.backend.dto.UserDto;
import com.greencommute.backend.entity.Jobs;
import com.greencommute.backend.entity.Skills;
import com.greencommute.backend.entity.User;
import com.greencommute.backend.exception.DataNotFoundException;
import com.greencommute.backend.mapper.UserMapper;
import com.greencommute.backend.service.SavedJobServiceImpl;
import com.greencommute.backend.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public SavedJobServiceImpl savedJobService;

    @Autowired
    public UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") int id) {
        Optional<User> user = userService.getUserById(id);
        if (!user.isPresent()) {
            throw new DataNotFoundException("No user with id: " + id);
        }
        UserDto userDto = userMapper.INSTANCE.toUserDto(user.get());
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/{id}/savedJobs")
    public List<Jobs> getSavedJobsOfUser(@PathVariable(value = "id") int id) {
        return savedJobService.getSavedJobsByUserID(id);
    }

    @PostMapping("/{id}/savedJobs")
    public ResponseDto saveJobsForUser(@PathVariable(value = "id") int id, @RequestBody Map<String,Integer> reqPayload) {
        List<Jobs> savedJobList= savedJobService.getSavedJobsByUserID(id).stream().filter(jobs -> {
            int savedJobId=jobs.getJobId();
            if(savedJobId == reqPayload.get("jobId")){
                return true;
            }
            else return false;
        }).collect(Collectors.toList());
        if(savedJobList.size()!=0){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setUserId(id);
            responseDto.setJobId(reqPayload.get("jobId"));
            responseDto.setMessage("Job already added to saved jobs");
            return responseDto;
        }
        else {
            savedJobService.saveToSavedJobs(id, reqPayload.get("jobId"));
            ResponseDto responseDto = new ResponseDto();
            responseDto.setUserId(id);
            responseDto.setJobId(reqPayload.get("jobId"));
            responseDto.setMessage("Successfully added to saved jobs");
            return responseDto;
        }
    }

    @DeleteMapping("/{id}/savedJobs")
    public ResponseDto deleteSavedJobsOfUser(@PathVariable(value="id") int id, @RequestBody Map<String,Integer> reqPayload) {
        Boolean res=savedJobService.deleteSavedJobs(id,reqPayload.get("jobId"));
        ResponseDto responseDto=new ResponseDto();
        responseDto.setUserId(id);
        responseDto.setJobId(reqPayload.get("jobId"));
        if(res){
            responseDto.setMessage("Successfully deleted saved job");
        }
        else {
            responseDto.setMessage("No saved job found with user id and job id");
        }
        return responseDto;
    }
}