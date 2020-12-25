package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.Professor;

class ProfessorDAOTest extends DAOTest {

    @Autowired
    private DAO<Professor> profdao;
    
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = profdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        Professor prof = profdao.getById(id);
        String newname = "Another Name";
        prof.setName(newname);
        profdao.update(id, prof);
        assertEquals(newname, profdao.getById(id).getName());
    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = profdao.getIdList().size() - 1;
        Professor prof =  profdao.getById(2);
        profdao.delete(prof);
        assertEquals(expectedResult, profdao.getIdList().size());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = profdao.getIdList().size() + 1;
        Professor prof = new Professor();
        prof.setName("Pit Bull");
        prof.setRanksTitles("The Most Aggressive One");
        prof.setSpecialNotes("Students Beware");
        profdao.create(prof);
        assertEquals(expectedSize, profdao.getIdList().size());
    }

    @Test
    void testGetById() throws DAOException {
        Professor prof = profdao.getById(1);
        assertNotNull(prof);
    }

}
