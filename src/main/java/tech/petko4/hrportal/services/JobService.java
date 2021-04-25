package tech.petko4.hrportal.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import tech.petko4.hrportal.dto.JobPreviewDto;

@Service
public interface JobService {

    Set<JobPreviewDto> getAllJobPreviewDto();
}
