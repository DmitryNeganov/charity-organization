package org.dvn.charity.organization.service.mapper;

import org.dvn.charity.organization.api.dto.ProjectDto;
import org.dvn.charity.organization.persistence.entity.Project;
import org.springframework.stereotype.Service;

/**
 * The type Project mapper.
 */
@Service
public class ProjectMapper {

    /**
     * Map project.
     *
     * @param projectDto the project dto
     * @return the project
     */
    public Project map(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setInvolvementDegree(projectDto.getInvolvementDegree());
        project.setBudget(projectDto.getStartingBudget());
        project.setActive(true);

        return project;
    }
}
