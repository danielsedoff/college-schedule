package com.danielsedoff.college.schedule.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.danielsedoff.college.schedule.config.WebConfig;
import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.service.CourseService;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@ContextConfiguration(classes = WebConfig.class)

@WebAppConfiguration
public class CourseListControllerTest {
    @Mock
    CourseDAO coursedao;
    
    @Mock
    CourseService courseService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void mockInitializer() throws Exception {
        MockitoAnnotations.initMocks(this);
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
        Course course = new Course();
        course.setId(1);
        course.setName("Algebra");
        List<Integer> ids = List.of(1, 2, 3);
        Mockito.when(courseService.getCourseIdList()).thenReturn(ids);
        Mockito.when(courseService.getCourseById(Mockito.anyInt())).thenReturn(course);

        Mockito.when(coursedao.getIdList()).thenReturn(ids);
        
        ResultActions performResult = mockMvc.perform(get("/courses"));
        ResultActions resultPrint = performResult.andDo(print());
        resultPrint.andExpect(view().name("courses"));
    }

    @Test
    public void givenCourseURI_whenMockMVC_thenVerifyResponse() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/courses")).andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.testvalue").value("passed"))
                .andReturn();

        assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
    }
}
