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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class LessonRestControllerTest extends ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void restGetLessonsShouldReturnThis() throws Exception {
        mockMvc.perform(get("/lessons")).andDo(print()).andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restGetLessonOneShouldReturnThis() throws Exception {
        mockMvc.perform(get("/lessons/1")).andDo(print()).andExpect(MockMvcResultMatchers.content().json(
                "{\"mode\":\"update\",\"id\":1,\"startTime\":\"2019-01-01 00:01\",\"endTime\":\"2019-01-01 01:01\",\"professorId\":1,\"groupId\":2}"));
    }

    @Test
    void restDeleteLessonThreeShouldReturnThis() throws Exception {
        mockMvc.perform(delete("/lessons/3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void restPostLessonShouldReturnThis() throws Exception {
        mockMvc.perform(post("/lessons").contentType(MediaType.APPLICATION_JSON).content(
                "{\"startTime\":\"2011-01-01 00:01\",\"endTime\":\"2012-01-01 01:01\",\"professorId\":1,\"groupId\":2}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void restPutLessonShouldReturnThis() throws Exception {
        mockMvc.perform(put("/lessons/1").contentType(MediaType.APPLICATION_JSON).content(
                "{\"mode\":\"update\",\"id\":1,\"startTime\":\"2011-01-01 00:01\",\"endTime\":\"2012-01-01 01:01\",\"professorId\":1,\"groupId\":2}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
