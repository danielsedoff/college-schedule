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

import com.danielsedoff.college.schedule.dao.DAOException.GroupDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.StudentDAOException;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

class GroupDAOTest extends DAOTest {

    @Autowired
    private GroupDAO groupdao;
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws GroupDAOException {
        List<Integer> result = groupdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetById() throws GroupDAOException {
        Group group = groupdao.getById(1);
        assertNotNull(group);
    }

    @Test
    void testUpdate() throws GroupDAOException {
        int id = 1;
        List<String> noteList = new ArrayList<>();
        String note = "Large group";
        noteList.add(note);
        Group group = groupdao.getById(id);
        group.setDepartmentId(4);
        group.setSpecialNotes(noteList);
        groupdao.update(id, group);
        Group newGroup = groupdao.getById(id);
        assertEquals(note, newGroup.getSpecialNotes().get(0));
    }

    @Test
    void testDelete() throws GroupDAOException {
        int expectedResult = groupdao.getIdList().size() - 1;
        Group group = new Group();
        group.setId(1);
        groupdao.delete(group);
        assertEquals(expectedResult, groupdao.getIdList().size());
    }

    @Test
    void testCreate() throws GroupDAOException {
        int expectedSize = groupdao.getIdList().size() + 1;
        Group group = new Group();
        group.setDepartmentId(65535);
        List<String> specialNotes = new ArrayList<>();
        specialNotes.add("Info");
        group.setSpecialNotes(specialNotes);
        groupdao.create(group);
        assertEquals(expectedSize, groupdao.getIdList().size());
        assertEquals(65535, groupdao.getById(expectedSize).getDepartmentId());
    }

    @Test
    void testSetGroupStudent() throws GroupDAOException, StudentDAOException {
        Group group = groupdao.getById(1);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        students.add(student);
        groupdao.setGroupStudent(group, students);
        List<Student> requestedStudents = groupdao.getStudentsByGroup(group);
        int lastIndex = requestedStudents.size() - 1;
        assertEquals(1, requestedStudents.get(lastIndex).getId());
    }

    @Test
    void testGetStudentsByGroup() throws GroupDAOException, StudentDAOException {
        Group group = groupdao.getById(3);
        assertNotNull(groupdao.getStudentsByGroup(group));
    }

}
