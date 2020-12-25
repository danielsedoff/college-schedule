package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.danielsedoff.college.schedule.config.TestConfig;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class CourseDAOTest extends DAOTest {

    @Test
    public void displayAllBeans() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println("bean: " + beanName);
        }
    }

    @Autowired
    private DAO<Course> coursedao;
    
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = coursedao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetById() throws DAOException {
        Course result = coursedao.getById(1);
        assertNotNull(result);
    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = coursedao.getIdList().size() - 1;
        Course course = new Course();
        course.setId(1);
        coursedao.delete(course);
        assertEquals(expectedResult, coursedao.getIdList().size());
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        Course course = coursedao.getById(id);
        String newDescription = "New Description";
        course.setCourseDescription(newDescription);
        coursedao.update(id, course);
        assertEquals(newDescription, coursedao.getById(id).getCourseDescription());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = coursedao.getIdList().size() + 1;
        String newName = "Chemistry";
        Course course = new Course();
        course.setName(newName);
        course.setProfessor(new ArrayList<Professor>());
        coursedao.create(course);
        assertEquals(expectedSize, coursedao.getIdList().size());
        assertEquals(newName, coursedao.getById(5).getName());
    }
    

}
