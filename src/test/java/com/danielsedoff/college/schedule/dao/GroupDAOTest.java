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
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@Service
class GroupDAOTest {

    final String SQL_FILE_NAME = "create_tables.sql";

    @Autowired
    private GroupDAO groupdao;
    @Autowired
    private StudentDAO studentdao;
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() {
        List<Integer> result = groupdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetById() {
        Group group = groupdao.getById(1);
        assertNotNull(group);
    }

    @Test
    void testUpdate() {
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
    void testDelete() {
        int expectedResult = groupdao.getIdList().size() - 1;
        Group group = new Group();
        group.setId(1);
        groupdao.delete(group);
        assertEquals(expectedResult, groupdao.getIdList().size());
    }

    @Test
    void testCreate() {
        int expectedSize = groupdao.getIdList().size() + 1;
        Group group = new Group();
        List<String> noteList = new ArrayList<>();
        String note = "Large group";
        noteList.add(note);
        group.setSpecialNotes(noteList);
        groupdao.create(group);
        assertEquals(expectedSize, groupdao.getIdList().size());
        assertEquals(note, groupdao.getById(5).getSpecialNotes().get(0));
    }

    @Test
    void testSetGroupStudent() {
        Group group = groupdao.getById(1);
        List<Student> students = new ArrayList<>();
        students.add(studentdao.getById(1));
        groupdao.setGroupStudent(group, students);
        List<Student> requestedStudents = groupdao.getStudentsByGroup(studentdao, group);
        assertEquals(requestedStudents, students);
    }

    @Test
    void testGetStudentsByGroup() {
        Group group = groupdao.getById(3);
        assertNotNull(groupdao.getStudentsByGroup(studentdao, group));
    }

}
