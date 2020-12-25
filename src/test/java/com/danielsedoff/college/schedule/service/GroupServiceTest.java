package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.model.Group;

class GroupServiceTest {
    GroupDAO groupdao = Mockito.mock(GroupDAO.class);

    GroupService gservice = new GroupService(groupdao);

    @Test
    void testGetGroupIdList() throws DAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(groupdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = gservice.getGroupIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateGroup() throws DAOException {
        Group group = new Group();
        Mockito.when(groupdao.create(group)).thenReturn(true);
        boolean successfulCreation = gservice.createGroup(group);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateGroup() throws DAOException {
        int groupId = 1;
        Group group = new Group();
        Mockito.when(groupdao.update(groupId, group)).thenReturn(true);
        boolean successfulUpdate = gservice.updateGroup(groupId, group);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteGroupById() throws DAOException {
        Mockito.when(groupdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = gservice.deleteGroupById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetGroupById() throws DAOException {
        Group group = new Group();
        Mockito.when(groupdao.getById(Mockito.anyInt())).thenReturn(group);
        assertNotNull(gservice.getGroupById(1));
    }

}
