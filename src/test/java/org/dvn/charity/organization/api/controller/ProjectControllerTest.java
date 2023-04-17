package org.dvn.charity.organization.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("getAllProject testing")
    class GetAllProjectsTest {
        @Test
        void shouldReturnAllProjects_soResponseIs200() throws Exception{
            List<Project> projectList = new ArrayList<>();
            projectList.add(getCorrectProject());
            given(projectService.getAllProjects()).willReturn(projectList);

            mvc.perform(get("/projects/"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpectAll(
                            jsonPath("$").isArray(),
                            jsonPath("$[0].id").value(1),
                            jsonPath("$[0].projectName").value("New Project"),
                            jsonPath("$[0].involvementDegree").value(3),
                            jsonPath("$[0].budget").value(1000.00f),
                            jsonPath("$[0].active").value(true)
                    );
        }

//        @Test
//        void shouldNotReturnAllProjects_
    }

    private Project getCorrectProject() {
        var project = new Project();
        project.setId(1);
        project.setProjectName("New Project");
        project.setBudget(1000.00F);
        project.setInvolvementDegree(3);
        project.setActive(true);

        return project;
    }


}
