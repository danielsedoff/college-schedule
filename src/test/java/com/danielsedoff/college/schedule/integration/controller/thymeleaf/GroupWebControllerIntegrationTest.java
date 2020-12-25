package com.danielsedoff.college.schedule.integration.controller.thymeleaf;

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
class GroupWebControllerIntegrationTest {

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
        assertNotNull(wac.getBean("groupWebController"));
    }

    @Test
    void mockMvcShouldReturnViewName() throws Exception {
        mockMvc.perform(get("/groupList")).andDo(print()).andExpect(view().name("groupList"));
    }

    @Test
    void responseShouldContainAttribute() throws Exception {
        mockMvc.perform(get("/groupList")).andExpect(status().isOk()).andExpect(model().attributeExists("testvalue"));
    }

    @Test
    void getGroupListShouldReturnGroupListTemplate() throws Exception {
        mockMvc.perform(get("/groupList")).andDo(print()).andExpect(view().name("groupList"));
    }

    @Test
    void getGroupFormShouldReturnGroupFormTemplate() throws Exception {
        mockMvc.perform(get("/groupForm").param("id", "-1")).andDo(print()).andExpect(view().name("groupForm"));
    }

    @Test
    void postDeleteGroupShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/deleteGroup")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateGroupShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/createGroup").param("id", "3").param("description", "Penguin Group").param("name", "PG"))
                .andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateGroupShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/updateGroup").param("id", "1").param("description", "Penguin Group").param("name", "PG"))
                .andDo(print()).andExpect(view().name("resultPage"));
    }

}
