package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.ProjectDto;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.persistence.repository.ProjectRepo;
import org.dvn.charity.organization.service.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Project> getProjectById(long id) {
        return projectRepository.findById(id);
    }

    /**
     * Create project.
     *
     * @param projectDto the project dto
     * @return the project
     */
    public Project createProject(ProjectDto projectDto) {
        Project project = projectMapper.map(projectDto);;
//        try {
//            project = projectMapper.map(projectDto);
//        } catch (Exception e) {
//            return Optional.empty();
//        }

        return projectRepository.save(project);
    }

    /**
     * Deactivate project.
     *
     * @param id the id
     * @return the project
     */
    public Optional<Project> deactivateProject(long id) {
        var project = getProjectById(id);
        if (project.isEmpty()) {
            return Optional.empty();
        }
        return project.map(p -> {
            p.setActive(false);
            projectRepository.save(p);
            return p;
        });
    }

    /**
     * Acrivate project.
     *
     * @param id the id
     * @return the project
     */
    public Optional<Project> activateProject(long id) {
        var project = getProjectById(id);
        if (project.isEmpty()) {
            return Optional.empty();
        }
        return project.map(p -> {
            p.setActive(true);
            projectRepository.save(p);
            return p;
        });
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
     * Increase project budget.
     *
     * @param project the project
     * @return the project
     */
    Project updateProject(Project project) {
        return projectRepository.save(project);
    }
}
