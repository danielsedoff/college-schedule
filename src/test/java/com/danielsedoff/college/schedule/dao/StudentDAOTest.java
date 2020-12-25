package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Student;

@Component
class StudentDAOTest {

    private JdbcTemplate jdbctemplate = new JdbcTemplate();
    private StudentDAO studentdao = new StudentDAO(this.jdbctemplate);

    @Test
    void testGetIdList() {
        List<Integer> result = studentdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() {
        int id = 1;
        int deptId = 1337;
        Student stud = studentdao.getById(id);
        stud.setDepartmentId(deptId);
        studentdao.update(id, stud);
        assertEquals(deptId, studentdao.getById(id).getDepartmentId());
    }

    @Test
    void testDelete() {
        int expectedResult = studentdao.getIdList().size() - 1;
        Student stud = new Student();
        stud.setId(1);
        studentdao.delete(stud);
        assertEquals(expectedResult, studentdao.getIdList().size());
    }

    @Test
    void testCreate() {
        int expectedSize = studentdao.getIdList().size() + 1;
        Student stud = new Student();
        int deptId = 1337;
        stud.setDepartmentId(deptId);
        studentdao.create(stud);
        assertEquals(expectedSize, studentdao.getIdList().size());
        assertEquals(deptId, studentdao.getById(5).getDepartmentId());
    }

    @Test
    void testGetById() {
        Student stud = studentdao.getById(1);
        assertNotNull(stud);
    }

}
