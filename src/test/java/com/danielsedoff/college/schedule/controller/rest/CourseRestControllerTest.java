package com.danielsedoff.college.schedule.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class CourseRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void restGetLessonsShouldReturnThis() throws Exception {
        mockMvc.perform(get("/courses")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restGetLessonOneShouldReturnThis() throws Exception {
        mockMvc.perform(get("/courses/1")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restDeleteLessonThreeShouldReturnThis() throws Exception {
        mockMvc.perform(delete("/courses/3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void restPostLessonShouldReturnThis() throws Exception {
        mockMvc.perform(post("/courses")).andExpect(status().is4xxClientError());
    }

    @Test
    void restPutLessonShouldReturnThis() throws Exception {
        mockMvc.perform(put("/courses/1")).andDo(print()).andExpect(status().is4xxClientError());
    }

}
