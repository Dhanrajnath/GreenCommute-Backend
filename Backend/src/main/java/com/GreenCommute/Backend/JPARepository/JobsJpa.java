package com.GreenCommute.Backend.JPARepository;

import com.GreenCommute.Backend.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsJpa extends JpaRepository<Jobs,Integer> {

    @Query(value = "SELECT * FROM jobs where job_location=?1",
            nativeQuery = true)
    List<Jobs> getJobsByLocation(String location);
}
