package com.GreenCommute.Backend.Helper;

import com.GreenCommute.Backend.Entity.Jobs;
import com.GreenCommute.Backend.Entity.Skills;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Helper {
    public List<String> getSkills(List<Skills> skillsList) {
        List<String> jobSkills = new ArrayList<>();
        for (Skills skills : skillsList) {
            jobSkills.add(skills.getSkillName());
        }
        return jobSkills;
    }

    public List<Jobs> getJobsSearchBySkills(List<Jobs> jobsList, String[] skillToSearch){
        return jobsList.stream().filter(job -> {
            List<Skills> skill = job.getSkillList();
            List<String> skillNames = getSkills(skill);
            for (String skillName : skillToSearch) {
                if (skillNames.indexOf(skillName) != -1)
                    return true;
            }
            return false;
        }).toList();
    }
}
