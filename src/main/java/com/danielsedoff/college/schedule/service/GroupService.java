package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException.GroupDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.StudentDAOException;
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

    public List<Integer> getGroupIdList() throws GroupDAOException {
        return groupdao.getIdList();
    }

    public boolean createGroup(Group group) throws GroupDAOException {
        return groupdao.create(group);
    }

    public boolean updateGroup(int groupId, Group group) throws GroupDAOException {
        return groupdao.update(groupId, group);
    }

    public boolean deleteGroupById(int groupId) throws GroupDAOException {
        return groupdao.delete(groupdao.getById(groupId));
    }

    public Group getGroupById(int groupId) throws GroupDAOException {
        return groupdao.getById(groupId);
    }

    public boolean setGroupStudent(int groupId, List<Student> students)
            throws GroupDAOException {
        return groupdao.setGroupStudent(groupdao.getById(groupId), students);
    }

    public List<Student> getStudentsByGroupId(int groupId) throws GroupDAOException, StudentDAOException {
        Group group = groupdao.getById(groupId);
        return groupdao.getStudentsByGroup(group);
    }

}
