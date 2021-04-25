package tech.petko4.hrportal;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.petko4.hrportal.dao.JobRepository;
import tech.petko4.hrportal.domain.job.Job;
import tech.petko4.hrportal.domain.job.Requirement;

@SpringBootApplication()
public class HrPortalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrPortalApplication.class, args);
	}

	@Autowired
	JobRepository jobRepository;
	
    @Override
    public void run(String... args) throws Exception {
        jobRepository.deleteAll();
        
        for(int i = 0; i < 10; i++) {
            var job = new Job("Job"+i, "Job description ... " + i, "Job description preview ..." + i, new HashSet<Requirement>());
            for(int j = 0; j < 10; j++) {
                var requirement = new Requirement("requirement " + i + j, new HashSet<>());
                job.addRequirement(requirement);
                requirement.addJob(job);
            }
            jobRepository.save(job);
        }
    }

}
