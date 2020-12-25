package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.dao.GroupRepository;
import com.danielsedoff.college.schedule.model.Group;

@SpringBootTest
class GroupServiceTest extends AbstractServiceTest {
    GroupRepository groupdao = Mockito.mock(GroupRepository.class);

    @Autowired
    GroupService gservice = new GroupService();

    @Test
    void testCreateGroup() throws Exception {
        Group group = new Group();
        group.setSpecialNotes("Any Group");
        Mockito.when(groupdao.save(Mockito.any())).thenReturn(true);
        boolean successfulCreation = gservice.createGroup(group);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateGroup() throws Exception {
        int groupId = 1;
        Group group = new Group();
        group.setSpecialNotes("Any Group");
        boolean successfulUpdate = gservice.updateGroup(groupId, group);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteGroupById() throws Exception {
        groupdao.delete(Mockito.any());
        boolean successfulDeletion = gservice.deleteGroupById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetGroupById() throws Exception {
        Group group = new Group();
        Mockito.when(groupdao.findById(Mockito.anyInt())).thenReturn(Optional.of(group));
        assertNotNull(gservice.getGroupById(1));
    }

}
