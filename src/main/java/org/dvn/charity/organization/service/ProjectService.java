package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.ProjectDto;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.persistence.repository.ProjectRepo;
import org.dvn.charity.organization.service.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Project service.
 */
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepository;
    private final ProjectMapper projectMapper;

    /**
     * Gets all projects.
     *
     * @return the all projects
     */
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    /**
     * Gets project by id.
     *
     * @param id the id
     * @return the project by id
     */
    public Project getProjectById(long id) {
        return projectRepository.findById(id).orElse(null);
    }

    /**
     * Create project project.
     *
     * @param projectDto the project dto
     * @return the project
     */
    public Project createProject(ProjectDto projectDto) {
        var project = projectMapper.map(projectDto);

        return projectRepository.save(project);
    }

    /**
     * Deacrivate project project.
     *
     * @param id the id
     * @return the project
     */
    public Project deacrivateProject(long id) {
        var project = projectRepository.findById(id).orElse(null);
        project.setActive(false);

        return project;
    }

    /**
     * Acrivate project project.
     *
     * @param id the id
     * @return the project
     */
    public Project acrivateProject(long id) {
        var project = projectRepository.findById(id).orElse(null);
        project.setActive(true);

        return project;
    }

    /**
     * Gets all invocation degree sum.
     *
     * @return the all invocation degree sum
     */
    public float getAllInvolvementDegreesSum() {
        return projectRepository.getAllInvocationDegreesSum();
    }

    /**
     * Increase project budget project.
     *
     * @param project the project
     * @return the project
     */
    Project updateProject(Project project) {
        return projectRepository.save(project);
    }
}
