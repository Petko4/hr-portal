package tech.petko4.hrportal.services.implementation;

import java.util.Set;

import org.springframework.stereotype.Service;

import tech.petko4.hrportal.dao.JobRepository;
import tech.petko4.hrportal.dto.JobPreviewDto;
import tech.petko4.hrportal.services.JobService;

@Service
public class JobServiceImpl implements JobService{

    
    private JobRepository jobRepository;
    
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    
    @Override
    public Set<JobPreviewDto> getAllJobPreviewDto() {
        return jobRepository.getAllJobPreviewDto();
    }

}
