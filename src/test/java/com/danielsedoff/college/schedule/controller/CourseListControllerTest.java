package com.danielsedoff.college.schedule.controller;

import javax.servlet.ServletContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.config.MainWebAppInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainWebAppInitializer.class })
@WebAppConfiguration
public class CourseListControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    public void givenWac_whenServletContext_thenItProvidesMainPageController() {
        ServletContext servletContext = wac.getServletContext();
        
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("mainPageController"));
    }
    
    @Test
    public void givenCourseURI_whenMockMVC_thenReturnsCourseViewName() throws Exception {
        this.mockMvc.perform(get("/courses")).andDo(print()).andExpect(view().name("courses"));
    }
    
    @Test
    public void givenCourseURI_whenMockMVC_thenVerifyResponse() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/courses"))
          .andDo(print()).andExpect(status().isOk())
          .andExpect(jsonPath("$.testvalue").value("passed"))
          .andReturn();
        
        Assert.assertEquals("application/json;charset=UTF-8", 
          mvcResult.getResponse().getContentType());
    }
}
