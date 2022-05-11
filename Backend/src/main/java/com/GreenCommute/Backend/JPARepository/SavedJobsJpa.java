package com.GreenCommute.Backend.JPARepository;

import com.GreenCommute.Backend.Entity.SavedJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedJobsJpa extends JpaRepository<SavedJobs,Integer> {
}
