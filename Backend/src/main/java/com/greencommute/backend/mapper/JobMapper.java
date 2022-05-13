package com.greencommute.backend.mapper;

import com.greencommute.backend.dto.JobsDto;
import com.greencommute.backend.entity.Jobs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    @Mapping(source = "jobId", target = "jobId")
    JobsDto toJobsDto(Jobs optionalJobs);

    List<JobsDto> toJobDtoList(List<Jobs> jobsList) ;
}
