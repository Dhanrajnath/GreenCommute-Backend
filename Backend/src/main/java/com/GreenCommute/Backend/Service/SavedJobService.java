package com.GreenCommute.Backend.Service;

import com.GreenCommute.Backend.Entity.Jobs;

import java.util.List;

public interface SavedJobService {
    String saveToSavedJobs(int userId, int jobId);
    List<Jobs> getSavedJobsByUserID(int id);

    void deleteSavedJobs(int savedJobId);

}
