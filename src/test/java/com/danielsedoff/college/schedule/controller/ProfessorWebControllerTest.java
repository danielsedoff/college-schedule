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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.config.TestWebConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestWebConfig.class })
@WebAppConfiguration
class ProfessorWebControllerTest extends ControllerTest {

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
        assertNotNull(wac.getBean("professorWebController"));
    }

    @Test
    void mockMvcShouldReturnViewName() throws Exception {
        mockMvc.perform(get("/professorList")).andDo(print()).andExpect(view().name("professorList"));
    }

    @Test
    void responseShouldContainAttribute() throws Exception {
        mockMvc.perform(get("/professorList")).andExpect(status().isOk())
                .andExpect(model().attributeExists("testvalue"));
    }

    @Test
    void getProfessorListShouldReturnProfessorListTemplate() throws Exception {
        mockMvc.perform(get("/professorList")).andDo(print()).andExpect(view().name("professorList"));
    }

    @Test
    void getProfessorFormShouldReturnProfessorFormTemplate() throws Exception {
        mockMvc.perform(get("/professorForm").param("id", "-1")).andDo(print()).andExpect(view().name("professorForm"));
    }

    @Test
    void postDeleteProfessorShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/deleteProfessor")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateProfessorShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/createProfessor")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateProfessorShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/updateProfessor")).andDo(print()).andExpect(view().name("resultPage"));
    }

}
