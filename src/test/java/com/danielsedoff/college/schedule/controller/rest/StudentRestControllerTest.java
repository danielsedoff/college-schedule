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
class StudentRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void restGetStudentsShouldReturnThis() throws Exception {
        mockMvc.perform(get("/students")).andDo(print()).andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restGetStudentTwoShouldReturnThis() throws Exception {
        mockMvc.perform(get("/students/2")).andDo(print()).andExpect(MockMvcResultMatchers.content()
                .json("{'id':2,'mode':'update','name':'Jimmy Carter','groupId':2,'schoolYear':1}"));
    }

    @Test
    void restDeleteStudentThreeShouldReturnThis() throws Exception {
        mockMvc.perform(delete("/students/3")).andDo(print()).andExpect(status().isOk());
    }

    
    @Test
    void restPostStudentShouldReturnThis() throws Exception {
        mockMvc.perform(post("/students").contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":2,\"mode\":\"update\",\"name\":\"Johnny\",\"groupId\":2,\"schoolYear\":2}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void restPutStudentShouldReturnThis() throws Exception {
        mockMvc.perform(put("/students/1").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Little John\",\"groupId\":3,\"mode\":\"create\",\"schoolYear\":1}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
