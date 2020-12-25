package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Service
public class GroupService {

    private GroupDAO groupdao;

    @Autowired
    public GroupService(GroupDAO groupdao, StudentDAO studentdao) {
        this.groupdao = groupdao;
    }

    private static Logger logger = LoggerFactory.getLogger(GroupService.class);

    public List<Integer> getGroupIdList() {
        List<Integer> result = null;
        try {
            result = groupdao.getIdList();
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean createGroup(Group group) {
        boolean result = false;
        try {
            result = groupdao.create(group);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean updateGroup(int groupId, Group group) {
        boolean result = false;
        try {
            result = groupdao.update(groupId, group);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean deleteGroupById(int groupId) {
        boolean result = false;
        try {
            result = groupdao.delete(groupdao.getById(groupId));
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Group getGroupById(int groupId) {
        Group result = null;
        try {
            result = groupdao.getById(groupId);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean setGroupStudent(int groupId, List<Student> students) {
        boolean result = false;
        try {
            result = groupdao.setGroupStudent(groupdao.getById(groupId), students);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public List<Student> getStudentsByGroupId(int groupId) {
        List<Student> result = null;
        try {
            Group group = groupdao.getById(groupId);
            result = groupdao.getStudentsByGroup(group);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

}
