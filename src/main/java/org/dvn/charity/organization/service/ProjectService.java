package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.persistence.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepository;

    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public Project getProjectById(long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project deacrivateProject(long id) {
        Project project = projectRepository.findById(id).orElse(null);
        project.setActive(false);

        return project;
    }

    public Project acrivateProject(long id) {
        Project project = projectRepository.findById(id).orElse(null);
        project.setActive(true);

        return project;
    }
}
