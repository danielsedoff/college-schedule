package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Service
public class GroupCommandExecutor {

    private static final String COULD_NOT_FIND_GROUP = "Could not find group.";
    private static final String WRONG_STUDENT_ID = "Wrong Student ID.";
    private static final String WRONG_DEPARTMENT_ID = "Wrong Department ID.";
    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";
    private static final String WRONG_GROUP_ID = "Wrong Group ID.";
    private GroupDAO groupdao;
    private StudentDAO studentdao;
    private static final String ARGUMENT_DELIMITER = "|";

    @Autowired
    public GroupCommandExecutor(GroupDAO groupdao, StudentDAO studentdao) {
        this.groupdao = groupdao;
        this.studentdao = studentdao;
    }

    public String getGroupIdList() {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = groupdao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String createGroup(String[] arguments) {
        boolean result = false;
        String specialNotes = arguments[0];
        String deptIdStr = arguments[1];
        int deptId = -1;
        try {
            deptId = Integer.parseInt(deptIdStr);
        } catch (Exception e) {
            return WRONG_DEPARTMENT_ID;
        }
        Group group = new Group();
        group.setDepartmentId(deptId);
        group.setSpecialNotes(List.of(specialNotes.split(ARGUMENT_DELIMITER)));
        result = groupdao.create(group);
        return result ? SUCCESS : FAILURE;
    }

    public String updateGroup(String[] arguments) {
        boolean result = false;
        String groupIdStr = arguments[0];
        int groupId = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        String specialNotes = arguments[1];
        String deptIdStr = arguments[2];
        int deptId = -1;
        try {
            deptId = Integer.parseInt(deptIdStr);
        } catch (Exception e) {
            return WRONG_DEPARTMENT_ID;
        }
        Group group = new Group();
        group.setDepartmentId(deptId);
        group.setSpecialNotes(List.of(specialNotes.split(ARGUMENT_DELIMITER)));
        result = groupdao.update(groupId, group);
        return result ? SUCCESS : FAILURE;
    }

    public String deleteGroup(String[] arguments) {
        boolean result = false;
        String groupIdStr = arguments[0];
        int groupId = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        result = groupdao.delete(groupdao.getById(groupId));
        return result ? SUCCESS : FAILURE;
    }

    public String getGroupById(String[] arguments) {
        String groupIdStr = arguments[0];
        int groupId = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        return groupdao.getById(groupId).toString();
    }

    public String setGroupStudent(String[] arguments) {
        String groupIdStr = arguments[0];
        int groupId = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        String studentIdStr = arguments[1];
        int studentId = -1;
        try {
            studentId = Integer.parseInt(studentIdStr);
        } catch (Exception e) {
            return WRONG_STUDENT_ID;
        }
        boolean result = false;
        List<Student> students = new ArrayList<>();
        students.add(studentdao.getById(studentId));
        result = groupdao.setGroupStudent(groupdao.getById(groupId), students);
        return result ? SUCCESS : FAILURE;
    }

    public String getStudentsByGroup(String[] arguments) {
        String groupIdStr = arguments[0];
        int groupId = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        Group group = null;
        try {
            group = groupdao.getById(groupId);
        } catch (Exception e) {
            return COULD_NOT_FIND_GROUP;
        }
        StringBuilder result = new StringBuilder();
        List<Student> students = groupdao.getStudentsByGroup(studentdao, group);
        for (Student student : students) {
            result.append(System.lineSeparator()).append(student.toString());
        }
        return result.toString();
    }

}
