package org.dvn.charity.organization.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.ProjectDto;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project controller.
 * ProjectDto is used for the validation and post data.
 */
@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Gets all projects.
     *
     * @return all projects
     */
    @GetMapping("/")
    @Operation(summary = "Get all the projects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<List<Project>> getAllProjects() {
        var projectList = projectService.getAllProjects();
        if (projectList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    /**
     * Gets project by id.
     *
     * @param id the id
     * @return the project by id
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get project by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long id) {
        var project = projectService.getProjectById(id);
        if (project.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project.orElseThrow(), HttpStatus.OK);
    }

    /**
     * Create project.
     *
     * @param projectDto
     * @return the project
     */
    @PostMapping("/")
    @Operation(summary = "Create project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Project created"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectDto projectDto) {
        return new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.CREATED);
    }

    /**
     * Deactivate project.
     *
     * @param id the id
     * @return the project
     */
    @GetMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate the project by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public ResponseEntity<Project> deactivateProject(@PathVariable long id) {
        var project = projectService.deactivateProject(id);
        if (project.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project.orElseThrow(), HttpStatus.OK);
    }

    /**
     * Activate project.
     *
     * @param id the id
     * @return the project
     */
    @GetMapping("/{id}/activate")
    @Operation(summary = "Activate the project by id")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public ResponseEntity<Project> activateProject(@PathVariable long id) {
        var project = projectService.activateProject(id);
        if (project.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project.orElseThrow(), HttpStatus.OK);
    }
}
