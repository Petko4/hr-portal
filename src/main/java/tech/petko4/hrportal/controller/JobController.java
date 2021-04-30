package tech.petko4.hrportal.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tech.petko4.hrportal.domain.job.Job;
import tech.petko4.hrportal.dto.JobPreviewDto;
import tech.petko4.hrportal.services.JobService;

@RestController
@RequestMapping("/api")
public class JobController {

    private JobService jobService;
    
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    
    @GetMapping("/job-previews")
    public Set<JobPreviewDto> jobPreviews() {
        return jobService.getAllJobPreviewDto();
        
    }
    
    
    @GetMapping("/jobs/{id}")
    public Job getJobDetail(@PathVariable Long id) {
        var job = jobService.getJob(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found"));
        return job;
    }
}
