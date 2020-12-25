package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

class GroupServiceTest {

    GroupService gservice = Mockito.mock(GroupService.class);

    @Test
    void testGetGroupIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(gservice.getGroupIdList()).thenReturn(mockList);
        List<Integer> idList = gservice.getGroupIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateGroup() {
        Group group = new Group();
        group.setDepartmentId(123);
        Mockito.when(gservice.createGroup(group)).thenReturn(true);
        boolean successfulCreation = gservice.createGroup(group);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateGroup() {
        int groupId = 1;
        Group group = new Group();
        group.setDepartmentId(123);
        Mockito.when(gservice.updateGroup(groupId, group)).thenReturn(true);
        boolean successfulUpdate = gservice.updateGroup(groupId, group);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteGroupById() {
        Mockito.when(gservice.deleteGroupById(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = gservice.deleteGroupById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetGroupById() {
        Group group = new Group();
        group.setDepartmentId(123);
        Mockito.when(gservice.getGroupById(Mockito.anyInt())).thenReturn(group);
        assertNotNull(gservice.getGroupById(1));
    }

    @Test
    void testSetGroupStudent() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        students.add(student);
        Mockito.when(gservice.setGroupStudent(Mockito.anyInt(), students)).thenReturn(true);
        boolean successfulSetDY = gservice.setGroupStudent(2, students);
        assertTrue(successfulSetDY);
    }

    @Test
    void testGetStudentsByGroupId() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        students.add(student);
        Mockito.when(gservice.getStudentsByGroupId(Mockito.anyInt())).thenReturn(students);
        List<Student> dayschedules = gservice.getStudentsByGroupId(1);
        assertNotNull(dayschedules);
    }

}
