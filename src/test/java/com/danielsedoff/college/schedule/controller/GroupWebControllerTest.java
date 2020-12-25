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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.config.TestWebConfig;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestWebConfig.class })
@WebAppConfiguration
class GroupWebControllerTest {

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
        mockMvc.perform(get("/groupList")).andExpect(status().isOk())
                .andExpect(model().attributeExists("testvalue"));
    }

    @Test
    void getGroupListShouldReturnGroupListTemplate() throws Exception {
        mockMvc.perform(get("/groupList")).andDo(print()).andExpect(view().name("groupList"));
    }

    @Test
    void getGroupFormShouldReturnGroupFormTemplate() throws Exception {
        mockMvc.perform(get("/groupForm").param("id", "-1")).andDo(print())
                .andExpect(view().name("groupForm"));
    }

    @Test
    void postDeleteGroupShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/deleteGroup")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postCreateGroupShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/createGroup")).andDo(print()).andExpect(view().name("resultPage"));
    }

    @Test
    void postUpdateGroupShouldReturnResultPage() throws Exception {
        mockMvc.perform(post("/updateGroup")).andDo(print()).andExpect(view().name("resultPage"));
    }

}