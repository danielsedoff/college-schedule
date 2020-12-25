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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class StudentWebControllerTest extends ControllerTest {

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
        assertNotNull(wac.getBean("studentWebController"));
    }

    @Test
    void mockMvcShouldReturnViewName() throws Exception {
        mockMvc.perform(get("/studentList")).andDo(print()).andExpect(view().name("studentList"));
    }

    @Test
    void responseShouldContainAttribute() throws Exception {
        mockMvc.perform(get("/studentList")).andExpect(status().isOk()).andExpect(model().attributeExists("testvalue"));
    }

    @Test
    void getStudentListShouldReturnStudentListTemplate() throws Exception {
        mockMvc.perform(get("/studentList")).andDo(print()).andExpect(view().name("studentList"));
    }

    @Test
    void getStudentFormShouldReturnStudentFormTemplate() throws Exception {
        mockMvc.perform(get("/studentForm").param("id", "-1")).andDo(print()).andExpect(view().name("studentForm"));
    }

    @Test
    void postDeleteStudentShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/deleteStudent")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateStudentShouldReturnResultPage() throws Exception {
        mockMvc
         .perform(post("/createStudent")
          .param("name", "New Student")
          .param("groupId", "1") 
          .param("schoolYear", "3")) 
          .andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateStudentShouldReturnResultPage() throws Exception {
        mockMvc
        .perform(post("/updateStudent")
         .param("id", "2")
         .param("name", "New Student")
         .param("groupId", "1") 
         .param("schoolYear", "3")) 
         .andDo(print()).andExpect(view().name("resultPage"));
    }

}
