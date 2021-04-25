package tech.petko4.hrportal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.petko4.hrportal.dto.JobPreviewDto;
import tech.petko4.hrportal.services.JobService;

@RestController
@RequestMapping("/api")
public class JobController {

    private JobService jobService;
    
    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    
    @GetMapping("/job-previews")
    public Set<JobPreviewDto> jobPreviews() {
        return jobService.getAllJobPreviewDto();
        
    }
}
