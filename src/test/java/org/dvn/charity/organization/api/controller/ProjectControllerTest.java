package org.dvn.charity.organization.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.dvn.charity.organization.api.dto.ProjectDto;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.service.ProjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("getAllProjects testing")
    class GetAllProjectsTest {
        @Test
        @SneakyThrows
        void shouldReturnAllProjects_soResponseIs200() {
            List<Project> projectList = new ArrayList<>();
            projectList.add(getCorrectProject());
            given(projectService.getAllProjects()).willReturn(projectList);

            mvc.perform(MockMvcRequestBuilders.get("/projects/"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpectAll(
                            jsonPath("$").isArray(),
                            jsonPath("$[0].id").value(1),
                            jsonPath("$[0].projectName").value("Project"),
                            jsonPath("$[0].involvementDegree").value(3),
                            jsonPath("$[0].budget").value(1000.00f),
                            jsonPath("$[0].active").value(true)
                    );
        }

        @Test
        @SneakyThrows
        void shouldNotReturnAllProjects_soResponseIs404() {
            given(projectService.getAllProjects()).willReturn(Collections.emptyList());

            mvc.perform(MockMvcRequestBuilders.get("/projects/"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("getProject testing")
    class GetProjectByIdTest {
        @Test
        @SneakyThrows
        void shouldReturnProject_soResponseIs200() {
            given(projectService.getProjectById(1)).willReturn(Optional.of(getCorrectProject()));

            mvc.perform(MockMvcRequestBuilders.get("/projects/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpectAll(
                            jsonPath("$.id").value(1),
                            jsonPath("$.projectName").value("Project"),
                            jsonPath("$.involvementDegree").value(3),
                            jsonPath("$.budget").value(1000.00f),
                            jsonPath("$.active").value(true)
                    );
        }

        @Test
        @SneakyThrows
        void shouldNotReturnProject_soResponseIs404() {
            given(projectService.getProjectById(-1))
                    .willReturn(Optional.empty());
            mvc.perform(MockMvcRequestBuilders.get("/projects/1"))
                    .andExpect(status().isNotFound());
        }

    }

    @Nested
    @DisplayName("createProject testing")
    class CreateProjectTest {
        @Test
        @SneakyThrows
        void shouldCreateProject_accordingToReceivedData_soResponseIs200() {
            var projectDto = getCorrectProjectDto();
            given(projectService.createProject(projectDto)).willReturn(getCorrectProject());

            mvc.perform(post("/projects/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(projectDto)))
                    .andExpect(status().isCreated());
        }

        @Test
        @SneakyThrows
        void shouldNotCreateProject_becauseInvalidData_soResponseIs400() {
            var projectDto = new ProjectDto();
            given(projectService.createProject(projectDto)).willReturn(null);

            mvc.perform(post("/projects/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(projectDto)))
                    .andExpect(status().isBadRequest());
        }

    }

    private ProjectDto getCorrectProjectDto() {
        var projectDto = new ProjectDto();
        projectDto.setProjectName("Project");
        projectDto.setStartingBudget(1000.00F);
        projectDto.setInvolvementDegree(3);

        return projectDto;
    }

    private Project getCorrectProject() {
        var project = new Project();
        project.setId(1);
        project.setProjectName("Project");
        project.setBudget(1000.00F);
        project.setInvolvementDegree(3);
        project.setActive(true);

        return project;
    }


}
