package com.danielsedoff.college.schedule.integration.controller.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import com.danielsedoff.college.schedule.controller.ControllerTest;

@SpringBootTest
@AutoConfigureMockMvc
class ProfessorWebControllerTest extends ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void mainPageControllerMustNotBeNull() {
        ServletContext servletContext = wac.getServletContext();
        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(wac.getBean("professorWebController"));
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
        mockMvc.perform(post("/deleteProfessor").param("id", "4")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateProfessorShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/createProfessor").param("name", "Penguin").param("ranks", "Queen Penguin")
                .param("id", "-1").param("notes", "Big Bird").param("courseId", "1")).andDo(print())
                .andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateProfessorShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/updateProfessor").param("name", "Penguin").param("ranks", "Queen Penguin")
                .param("id", "-1").param("notes", "Big Bird")).andDo(print()).andExpect(view().name("resultPage"));
    }

}
