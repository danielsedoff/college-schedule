package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@Component
class CourseDAOTest {

    private JdbcTemplate jdbctemplate = new JdbcTemplate();
    private CourseDAO coursedao = new CourseDAO(this.jdbctemplate);
    private ProfessorDAO professordao;

    @Test
    void testGetIdList() {
        List<Integer> result = coursedao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetById() {
        Course result = coursedao.getById(1);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        int expectedResult = coursedao.getIdList().size() - 1;
        Course course = new Course();
        course.setId(1);
        coursedao.delete(course);
        assertEquals(expectedResult, coursedao.getIdList().size());
    }

    @Test
    void testUpdate() {
        int id = 1;
        Course course = coursedao.getById(id);
        String newDescription = "New Description";
        course.setCourseDescription(newDescription);
        coursedao.update(id, course);
        assertEquals(newDescription, coursedao.getById(id).getCourseDescription());
    }

    @Test
    void testCreate() {
        int expectedSize = coursedao.getIdList().size() + 1;
        String newName = "Chemistry";
        Course course = new Course();
        course.setName(newName);
        coursedao.create(course);
        assertEquals(expectedSize, coursedao.getIdList().size());
        assertEquals(newName, coursedao.getById(5).getName());
    }

    @Test
    void testSetProfessorList() {
        Course course = coursedao.getById(2);
        List<Professor> professors = new ArrayList<>();
        Professor prof = new Professor();
        prof.setName("Evangelista Torricelli");
        professors.add(prof);
        coursedao.setProfessorList(course, professors);
        List<Professor> requestedProfessors = coursedao.getProfessorByCourse(professordao,
                course);
        assertEquals(professors, requestedProfessors);
    }

    @Test
    void testGetProfessorByCourse() {
        Course course = coursedao.getById(3);
        List<Professor> professors = new ArrayList<>();
        Professor prof = new Professor();
        prof.setName("Leonardo Da Vinci");
        professors.add(prof);
        coursedao.setProfessorList(course, professors);
        List<Professor> requestedProfessors = coursedao.getProfessorByCourse(professordao,
                course);
        assertEquals(professors, requestedProfessors);
    }

}
