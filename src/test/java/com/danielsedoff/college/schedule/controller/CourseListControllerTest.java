package com.danielsedoff.college.schedule.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.config.WebConfig;
import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.service.CourseService;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebConfig.class, NameServiceTestConfiguration.class })
@WebAppConfiguration
public class CourseListControllerTest {
    @Mock
    CourseService courseService;

    @Mock
    CourseDAO coursedao;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesMainPageController() {
        ServletContext servletContext = wac.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(wac.getBean("mainPageController"));
    }

    @Test
    public void givenCourseURI_whenMockMVC_thenReturnsCourseViewName() throws Exception {
        mockMvc.perform(get("/courses")).andDo(print()).andExpect(view().name("courses"));
    }

    @Test
    public void givenCourseURI_whenMockMVC_thenVerifyResponse() throws Exception {
        mockMvc.perform(get("/courses")).andExpect(status().isOk())
                .andExpect(model().attributeExists("testvalue"));
    }
}
