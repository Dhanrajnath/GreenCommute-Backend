package com.greencommute.backend.service;

import com.greencommute.backend.entity.Jobs;

import java.util.List;

public interface SavedJobService {
    String saveToSavedJobs(int userId, int jobId);
    List<Jobs> getSavedJobsByUserID(int id);

    Boolean deleteSavedJobs(int userId,int jobId) throws Exception;

}
