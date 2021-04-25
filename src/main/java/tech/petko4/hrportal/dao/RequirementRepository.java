package tech.petko4.hrportal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.petko4.hrportal.domain.job.Requirement;


@Repository
public interface RequirementRepository extends CrudRepository<Requirement, Long>{

}
