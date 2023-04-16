package org.dvn.charity.organization.api.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.ProjectDto;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.persistence.repository.ProjectRepo;
import org.dvn.charity.organization.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Project controller.
 */
@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Gets all projects.
     *
     * @return the all projects
     */
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    /**
     * Gets project by id.
     *
     * @param id the id
     * @return the project by id
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project getProjectById(@PathVariable("id") long id) {
        return projectService.getProjectById(id);
    }

    /**
     * Create project project.
     *
     * @param projectDto the project dto
     * @return the project
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Project created"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project createProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

    /**
     * Deactivate project project.
     *
     * @param id the id
     * @return the project
     */
    @GetMapping("/{id}/deactivate")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project deactivateProject(@PathVariable long id) {
        return projectService.deacrivateProject(id);
    }

    /**
     * Activate project project.
     *
     * @param id the id
     * @return the project
     */
    @GetMapping("/{id}/activate")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Schema not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public Project activateProject(@PathVariable long id) {
        return projectService.acrivateProject(id);
    }
}
