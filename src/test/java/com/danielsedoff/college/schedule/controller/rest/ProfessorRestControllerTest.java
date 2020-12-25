package com.danielsedoff.college.schedule.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.repositories.SqlScriptRunner;

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
    void restGetProfessorsShouldReturnThis() throws Exception {
        mockMvc.perform(get("/professors")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void restGetProfessorTwoShouldReturnThis() throws Exception {
        mockMvc.perform(get("/professors/2")).andDo(print()).andExpect(MockMvcResultMatchers.content().json(
                "{'id':2,'mode':'update','name':'Graham Greene','ranks':'Order of the Companions of Honour','notes':'He wrote The Journey Without Maps'}"));
    }

    @Test
    void restDeleteProfessorTwoShouldReturnThis() throws Exception {
        mockMvc.perform(delete("/professors/2")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void restPostProfessorShouldReturnThis() throws Exception {
        mockMvc.perform(post("/professors").contentType(MediaType.APPLICATION_JSON).content(
                "{\"courseId\":1,\"id\":2,\"mode\":\"update\",\"name\":\"Ronnie Bruenswick\",\"ranks\":\"No titles\",\"notes\":\"Football club owner\"}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void restPutProfessorShouldReturnThis() throws Exception {
        mockMvc.perform(put("/professors/1").contentType(MediaType.APPLICATION_JSON).content(
                "{\"courseId\":1,\"id\":2,\"mode\":\"update\",\"name\":\"Big Professor\",\"ranks\":\"Pumpkin Eater\",\"notes\":\"The largest and fattest Professor\"}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
