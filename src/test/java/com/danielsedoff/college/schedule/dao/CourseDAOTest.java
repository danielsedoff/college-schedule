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
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.danielsedoff.college.schedule.config.AppConfig;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@Service
class CourseDAOTest {

    final String SQL_FILE_NAME = "create_tables.sql";

    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private ProfessorDAO professordao;
    @Autowired
    private SqlScriptRunner ibatisRead;
    
    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() {
        List<Integer> result = courseDAO.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetById() {
        Course result = courseDAO.getById(1);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        int expectedResult = courseDAO.getIdList().size() - 1;
        Course course = new Course();
        course.setId(1);
        courseDAO.delete(course);
        assertEquals(expectedResult, courseDAO.getIdList().size());
    }

    @Test
    void testUpdate() {
        int id = 1;
        Course course = courseDAO.getById(id);
        String newDescription = "New Description";
        course.setCourseDescription(newDescription);
        courseDAO.update(id, course);
        assertEquals(newDescription, courseDAO.getById(id).getCourseDescription());
    }

    @Test
    void testCreate() {
        int expectedSize = courseDAO.getIdList().size() + 1;
        String newName = "Chemistry";
        Course course = new Course();
        course.setName(newName);
        courseDAO.create(course);
        assertEquals(expectedSize, courseDAO.getIdList().size());
        assertEquals(newName, courseDAO.getById(5).getName());
    }

    @Test
    void testSetProfessorList() {
        Course course = courseDAO.getById(2);
        List<Professor> professors = new ArrayList<>();
        Professor prof = new Professor();
        prof.setName("Evangelista Torricelli");
        professors.add(prof);
        courseDAO.setProfessorList(course, professors);
        List<Professor> requestedProfessors = courseDAO.getProfessorByCourse(professordao,
                course);
        assertEquals(professors, requestedProfessors);
    }

    @Test
    void testGetProfessorByCourse() {
        Course course = courseDAO.getById(3);
        List<Professor> professors = new ArrayList<>();
        Professor prof = new Professor();
        prof.setName("Leonardo Da Vinci");
        professors.add(prof);
        courseDAO.setProfessorList(course, professors);
        List<Professor> requestedProfessors = courseDAO.getProfessorByCourse(professordao,
                course);
        assertEquals(professors, requestedProfessors);
    }

}
