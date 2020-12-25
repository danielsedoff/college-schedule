package com.danielsedoff.college.schedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Service
public class GroupService {

    private GroupDAO groupdao;
    private StudentDAO studentdao;
    private static final String ARGUMENT_DELIMITER = "|";

    @Autowired
    public GroupService(GroupDAO groupdao, StudentDAO studentdao) {
        this.groupdao = groupdao;
        this.studentdao = studentdao;
    }

    public List<Integer> getGroupIdList() {
        return groupdao.getIdList();
    }

    public boolean createGroup(int deptId, String specialNotes) {
        Group group = new Group();
        group.setDepartmentId(deptId);
        group.setSpecialNotes(List.of(specialNotes.split(ARGUMENT_DELIMITER)));
        return groupdao.create(group);
    }

    public boolean updateGroup(int groupId, Group group) {
        return groupdao.update(groupId, group);
    }

    public boolean deleteGroupById(int groupId) {
        return groupdao.delete(groupdao.getById(groupId));
    }

    public Group getGroupById(int groupId) {
        return groupdao.getById(groupId);
    }

    public boolean setGroupStudent(int groupId, List<Student> students) {
        return groupdao.setGroupStudent(groupdao.getById(groupId), students);
    }

    public List<Student> getStudentsByGroupId(int groupId) {
        Group group = groupdao.getById(groupId);
        return groupdao.getStudentsByGroup(studentdao, group);
    }

}
