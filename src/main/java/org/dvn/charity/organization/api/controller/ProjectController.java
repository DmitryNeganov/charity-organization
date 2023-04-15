package org.dvn.charity.organization.api.controller;

import org.dvn.charity.organization.persistence.entity.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @GetMapping("/")
    public List<Project> getAllProjects() {
        return null;
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") long id) {
        return null;
    }

}
