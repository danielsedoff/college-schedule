package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.Group;

class GroupDAOTest extends DAOTest {

    @Autowired
    private DAO<Group> groupdao;
    
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = groupdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetById() throws DAOException {
        Group group = groupdao.getById(1);
        assertNotNull(group);
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        String note = "Large group";
        Group group = groupdao.getById(id);
        group.setSpecialNotes(note);
        groupdao.update(id, group);
        Group newGroup = groupdao.getById(id);
        assertEquals(note, newGroup.getSpecialNotes());
    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = groupdao.getIdList().size() - 1;
        Group group = groupdao.getById(2);
        groupdao.delete(group);
        assertEquals(expectedResult, groupdao.getIdList().size());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = groupdao.getIdList().size() + 1;
        Group group = new Group();
        group.setSpecialNotes("Info");
        groupdao.create(group);
        assertEquals(expectedSize, groupdao.getIdList().size());
    }

}
