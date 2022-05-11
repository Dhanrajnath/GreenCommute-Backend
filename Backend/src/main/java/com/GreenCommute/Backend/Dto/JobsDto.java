package com.GreenCommute.Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobsDto {

    private int jobId;

    private String jobTitle;

    private String jobDescription;

    private String jobLocation;

}
