package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

class CourseDAOTest extends DAOTest {

    @Autowired
    private CourseDAO coursedao;
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
        coursedao.create(course);
        assertEquals(expectedSize, coursedao.getIdList().size());
        assertEquals(newName, coursedao.getById(5).getName());
    }

    @Test
    void testSetProfessorList() throws DAOException {
        Course course = coursedao.getById(2);
        List<Professor> professors = new ArrayList<>();
        Professor prof = new Professor();
        prof.setId(1);
        professors.add(prof);
        coursedao.setCourseProfessor(course, professors);
        List<Professor> requestedProfessors = coursedao.getProfessorByCourse(course);
        int lastIndex = requestedProfessors.size() - 1;
        assertEquals(1, requestedProfessors.get(lastIndex).getId());
    }

    @Test
    void testGetProfessorByCourse() throws DAOException {
        Course course = coursedao.getById(2);
        List<Professor> professors = new ArrayList<>();
        Professor prof = new Professor();
        prof.setId(2);
        professors.add(prof);
        coursedao.setCourseProfessor(course, professors);
        List<Professor> requestedProfessors = coursedao.getProfessorByCourse(course);
        int lastIndex = requestedProfessors.size() - 1;
        assertEquals(2, requestedProfessors.get(lastIndex).getId());
    }

}
