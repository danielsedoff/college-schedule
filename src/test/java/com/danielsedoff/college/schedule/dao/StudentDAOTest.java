package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.Student;

class StudentDAOTest extends DAOTest {

    @Autowired
    private DAO<Student> studentdao;
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = studentdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        String newname = "Jack Scart";
        Student stud = studentdao.getById(id);
        stud.setName(newname);
        studentdao.update(id, stud);
        assertEquals(newname, studentdao.getById(id).getName());
    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = studentdao.getIdList().size() - 1;
        Student stud = new Student();
        stud.setId(1);
        studentdao.delete(stud);
        assertEquals(expectedResult, studentdao.getIdList().size());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = studentdao.getIdList().size() + 1;
        Student stud = new Student();
        String newname = "Jack Scart";
        stud.setName(newname);
        studentdao.create(stud);
        assertEquals(expectedSize, studentdao.getIdList().size());
        assertEquals(newname, studentdao.getById(5).getName());
    }

    @Test
    void testGetById() throws DAOException {
        Student stud = studentdao.getById(1);
        assertNotNull(stud);
    }

}
