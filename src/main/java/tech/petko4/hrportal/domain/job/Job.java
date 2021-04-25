package tech.petko4.hrportal.domain.job;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Class represents a job advert entity in the hr portal system.
 * @author Petko4
 *
 */
@Entity
@Table(name = "jobs")
public class Job {
    
    @Id
    @SequenceGenerator(name = "job_id_seq", sequenceName = "jobs_job_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "job_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "job_id")
    private long id;
    @Column(name = "job_title")
    private String title;
    @Column(name = "job_description")
    private String description;
    @Column(name = "job_description_preview")
    private String descriptionPreview;
    
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(
            name = "jobs_requirements",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "requirement_id")
    )
    private Set<Requirement> requirements;

    public Job() {}
    
    public Job(String title, String description, String descriptionPreview, Set<Requirement> requirements) {
        this.title = title;
        this.description = description;
        this.descriptionPreview = descriptionPreview;
        this.requirements = requirements;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionPreview() {
        return descriptionPreview;
    }

    public void setDescriptionPreview(String descriptionPreview) {
        this.descriptionPreview = descriptionPreview;
    }

    public Set<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(Set<Requirement> requirements) {
        this.requirements = requirements;
    }
    
    
    public void addRequirement(Requirement requirement) {
        if(requirements == null) {
            requirements = new HashSet<>();
        }
        requirements.add(requirement);
    }
    

}
