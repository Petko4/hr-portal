package tech.petko4.hrportal.domain.job;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class represent a job requirement entity
 * @author petrv
 *
 */

@Entity
@Table(name="requirements")
public class Requirement {
    
    @Id
    @SequenceGenerator(name = "requirement_id_seq", sequenceName = "requirements_requirement_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "requirement_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "requirement_id")
    private Long id;
    
    @Column(name = "requirement_name")
    private String name;
    @ManyToMany(mappedBy = "requirements")
    private Set<Job> jobs;
    
    public Requirement(String name, Set<Job> jobs) {
        this.name = name;
        this.jobs = jobs;
    }

    public Requirement() {}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Job> getJobs() {
        return jobs;
    }
    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
    
    public void addJob(Job job) {
        if(jobs == null) {
            jobs = new HashSet<>();
        }
        jobs.add(job);
    }
    
    
}
