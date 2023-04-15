package org.dvn.charity.organization.api.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.persistence.repository.ProjectRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepo projectRepository;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project getProjectById(@PathVariable("id") long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Project created"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping("/{id}/deactivate")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project deactivateProject(@PathVariable long id) {
        Project project = projectRepository.findById(id).orElse(null);
        project.setActive(false);
        return project;
    }

    @GetMapping("/{id}/activate")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project activateProject(@PathVariable long id) {
        Project project = projectRepository.findById(id).orElse(null);
        project.setActive(true);
        return project;
    }
}
