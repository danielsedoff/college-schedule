package com.danielsedoff.college.schedule.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.danielsedoff.college.schedule.controller.thymeleaf.ControllerTest;

@SpringBootTest
@AutoConfigureMockMvc
class CourseRestControllerTest extends ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void restGetCoursesShouldReturnThis() throws Exception {
        mockMvc.perform(get("/courses")).andDo(print()).andExpect(MockMvcResultMatchers.content().json(
                "[{'mode':'update','id':1,'name':'Maths','description':'Mathematics','professorId':1},{'mode':'update','id':2,'name':'Bio','description':'Biology','professorId':2},{'mode':'update','id':3,'name':'Eng','description':'English','professorId':3},{'mode':'update','id':4,'name':'Hist','description':'History','professorId':4}]"));
    }

    @Test
    void restGetCourseTwoShouldReturnThis() throws Exception {
        mockMvc.perform(get("/courses/2")).andDo(print()).andExpect(MockMvcResultMatchers.content()
                .json("{'mode':'update','id':2,'name':'Bio','description':'Biology','professorId':2}"));
    }

    @Test
    void restDeleteCourseThreeShouldReturnThis() throws Exception {
        mockMvc.perform(delete("/courses/3")).andDo(print()).andExpect(status().isOk());
    }

    
    @Test
    void restPostCourseShouldReturnThis() throws Exception {
        mockMvc.perform(post("/courses").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"abc\",\"description\":\"Alphabet\",\"professorId\":2,\"mode\":\"create\",\"id\":1}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void restPutCourseShouldReturnThis() throws Exception {
        mockMvc.perform(put("/courses/1").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"abc\",\"description\":\"Alphabet\",\"professorId\":2,\"mode\":\"create\",\"id\":1}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
