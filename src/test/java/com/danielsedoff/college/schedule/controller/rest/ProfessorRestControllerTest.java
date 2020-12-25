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

import com.danielsedoff.college.schedule.controller.ControllerTest;

@SpringBootTest
@AutoConfigureMockMvc
class ProfessorRestControllerTest extends ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void restGetGroupsShouldReturnThis() throws Exception {
        mockMvc.perform(get("/professors")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restGetGroupTwoShouldReturnThis() throws Exception {
        mockMvc.perform(get("/professors/2")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restDeleteGroupThreeShouldReturnThis() throws Exception {
        mockMvc.perform(delete("/professors/3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void restPostGroupShouldReturnThis() throws Exception {
        mockMvc.perform(post("/professors").contentType(MediaType.APPLICATION_JSON).contentType("application/json"));
    }

    @Test
    void restPutGroupShouldReturnThis() throws Exception {
        mockMvc.perform(put("/professors/1").contentType(MediaType.APPLICATION_JSON).contentType("application/json"));
    }
}
