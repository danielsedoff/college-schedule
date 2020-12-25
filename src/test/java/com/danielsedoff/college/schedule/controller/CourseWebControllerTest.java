package com.danielsedoff.college.schedule.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.config.TestWebConfig;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestWebConfig.class })
@WebAppConfiguration
class CourseWebControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void mainPageControllerMustNotBeNull() {
        ServletContext servletContext = wac.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(wac.getBean("courseWebController"));
    }

    @Test
    void responseShouldContainAttribute() throws Exception {
        mockMvc.perform(get("/courseList")).andExpect(status().isOk())
        .andExpect(model().attributeExists("testvalue"));
    }

    @Test
    void getCourseListShouldReturnCourseListTemplate() throws Exception {
        mockMvc.perform(get("/courseList")).andDo(print()).andExpect(view().name("courseList"));
    }

    @Test
    void getCourseFormShouldReturnCourseFormTemplate() throws Exception {
        mockMvc.perform(get("/courseForm").param("id", "-1")).andDo(print())
                .andExpect(view().name("courseForm"));
    }

    @Test
    void postDeleteCourseShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/deleteCourse")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateCourseShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/createCourse")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateCourseShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/updateCourse")).andDo(print()).andExpect(view().name("resultPage"));
    }

}
