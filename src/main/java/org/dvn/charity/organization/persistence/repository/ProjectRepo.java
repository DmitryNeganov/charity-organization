package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Project repo.
 */
public interface ProjectRepo extends CrudRepository<Project, Long> {

    /**
     * Gets all invocation degrees sum.
     *
     * @return the all invocation degrees sum
     */
    @Query(value = "SELECT SUM(involvement_degree) FROM projects", nativeQuery = true)
    float getAllInvocationDegreesSum();
}
