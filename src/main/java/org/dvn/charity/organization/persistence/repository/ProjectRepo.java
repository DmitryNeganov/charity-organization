package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Long> {
}
