package com.greencommute.backend.service;

import com.greencommute.backend.entity.Jobs;

import java.util.List;

public interface SavedJobService {
    void saveToSavedJobs(int userId, int jobId);
    List<Jobs> getSavedJobsByUserID(int id);

    Boolean deleteSavedJobs(int userId,int jobId);

}
