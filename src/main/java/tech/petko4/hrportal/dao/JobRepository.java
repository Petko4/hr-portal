package tech.petko4.hrportal.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.petko4.hrportal.domain.job.Job;
import tech.petko4.hrportal.dto.JobPreviewDto;

@Repository
public interface JobRepository extends CrudRepository<Job, Long>{

    @Query(value="SELECT job_id as id, job_title as title, job_description_preview as descriptionPreview FROM jobs", nativeQuery = true)
    public Set<JobPreviewDto> getAllJobPreviewDto();
}
