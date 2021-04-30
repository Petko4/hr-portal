package tech.petko4.hrportal.services.implementation;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import tech.petko4.hrportal.dao.JobRepository;
import tech.petko4.hrportal.domain.job.Job;
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

    @Override
    public Optional<Job> getJob(Long id) {
        Optional<Job> opt = jobRepository.findWithRequirementsById(id);
        System.err.println(opt);
        return opt;
    }

}
