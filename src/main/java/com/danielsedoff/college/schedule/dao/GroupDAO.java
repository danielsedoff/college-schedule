package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.mappers.GroupMapper;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Service 
public class GroupDAO implements DAO<Group> {

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_GROUPZ = "SELECT group_id FROM groupz;";
    private static final String SQL_UPDATE_GROUPZ = "UPDATE groupz SET group_note = ?, department_id = ? WHERE group_id = ?;";
    private static final String SQL_DELETE_FROM_GROUPZ = "DELETE FROM groupz WHERE group_id = ?;";
    private static final String SQL_INSERT_INTO_GROUPZ = "INSERT INTO groupz (group_note, department_id) VALUES (?, ?);";
    private static final String SQL_SELECT_GROUP_BY_ID = "SELECT * FROM groupz where group_id = ?";
    private static final String SQL_INSERT_GROUP_STUDENT = "INSERT INTO group_student (group_id, student_id) VALUES(?, ?)";
    private static final String SQL_SELECT_STUDENT_BY_GROUP = "SELECT student_id FROM group_student WHERE group_id = ?";

    @Autowired
    public GroupDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_GROUPZ, Integer.class); 
    }

    public Group getById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_GROUP_BY_ID, new Object[] { id }, new GroupMapper());
    }

    public boolean delete(Group group) {
        return jdbcTemplate.update(SQL_DELETE_FROM_GROUPZ, group.getId()) > 0;
    }

    public boolean update(Integer id, Group group) {
        return jdbcTemplate.update(SQL_UPDATE_GROUPZ, group.getSpecialNotes(), group.getDepartmentId(),
                group.getId()) > 0;
    }

    public boolean create(Group group) {
        return jdbcTemplate.update(SQL_INSERT_INTO_GROUPZ, group.getSpecialNotes(), group.getDepartmentId()) > 0;
    }

    public boolean setGroupStudent(Group group, List<Student> students) {
        // TODO: Make it batch.
        boolean result = false;
        for(int i = 0; i < students.size(); i++) {
            jdbcTemplate.update(SQL_INSERT_GROUP_STUDENT, group.getId(), students.get(1).getId());
        }
        return result;
    }
    
    public List<Student> getStudentsByGroup(StudentDAO studentdao, Group group) {
        List<Integer> studentIds = jdbcTemplate.queryForList(SQL_SELECT_STUDENT_BY_GROUP, Integer.class, group.getId());
        List<Student> students = new ArrayList<>();
        for(Integer studentId : studentIds) {
            students.add(studentdao.getById(studentId));
        }
        return students;
    }

}