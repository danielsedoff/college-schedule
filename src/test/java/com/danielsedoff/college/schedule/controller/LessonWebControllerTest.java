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
class LessonWebControllerTest {

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
        assertNotNull(wac.getBean("lessonWebController"));
    }

    @Test
    void mockMvcShouldReturnViewName() throws Exception {
        mockMvc.perform(get("/lessonList")).andDo(print()).andExpect(view().name("lessonList"));
    }

    @Test
    void responseShouldContainAttribute() throws Exception {
        mockMvc.perform(get("/lessonList")).andExpect(status().isOk())
                .andExpect(model().attributeExists("testvalue"));
    }

    @Test
    void getLessonListShouldReturnLessonListTemplate() throws Exception {
        mockMvc.perform(get("/lessonList")).andDo(print()).andExpect(view().name("lessonList"));
    }

    @Test
    void getLessonFormShouldReturnLessonFormTemplate() throws Exception {
        mockMvc.perform(get("/lessonForm").param("id", "-1")).andDo(print())
                .andExpect(view().name("lessonForm"));
    }

    @Test
    void postDeleteLessonShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/deleteLesson")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateLessonShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/createLesson").param("endTime", "1999-01-01 14:14")
                .param("startTime", "1999-01-01 13:13")).andDo(print())
                .andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateLessonShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/updateLesson").param("endTime", "1999-01-01 14:14")
                .param("startTime", "1999-01-01 13:13")).andDo(print())
                .andExpect(view().name("resultPage"));
    }

}
