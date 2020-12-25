package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.model.Group;

@Service
public class GroupService {
    @Autowired
    private GroupDAO groupdao;

    @Autowired
    public GroupService(GroupDAO groupdao) {
        this.groupdao = groupdao;
    }

    private static Logger logger = LoggerFactory.getLogger(GroupService.class);

    public List<Group> getGroupList() {
        List<Group> result = null;
        try {
            result = groupdao.getList();
        } catch (DAOException e) {
            logger.error("Could not get a Student Id List", e);
        }
        return result;
    }
    
    public List<Integer> getGroupIdList() {
        List<Integer> result = null;
        try {
            result = groupdao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not Get Group ID List", e);
        }
        return result;
    }

    public boolean createGroup(Group group) {
        boolean result = false;
        try {
            result = groupdao.create(group);
        } catch (DAOException e) {
            logger.error("Could not Create a Group", e);
        }
        return result;
    }

    public boolean updateGroup(int groupId, Group group) {
        boolean result = false;
        try {
            result = groupdao.update(groupId, group);
        } catch (DAOException e) {
            logger.error("Could not Update a Group, groupId: {}", groupId);
        }
        return result;
    }

    public boolean deleteGroupById(int groupId) {
        boolean result = false;
        try {
            result = groupdao.delete(groupdao.getById(groupId));
        } catch (DAOException e) {
            logger.error("Could not Delete a Group, groupId: {}", groupId);
        }
        return result;
    }

    public Group getGroupById(int groupId) {
        Group result = null;
        try {
            result = groupdao.getById(groupId);
        } catch (DAOException e) {
            logger.error("Could not Get a Group, groupId: {}", groupId);
        }
        return result;
    }



}
