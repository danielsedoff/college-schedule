package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.DAOException.GroupDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.StudentDAOException;
import com.danielsedoff.college.schedule.dao.mappers.GroupMapper;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Component
public class GroupDAO implements DAO<Group> {

    @Autowired
    StudentDAO studentdao;

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_GROUPZ = "SELECT group_id FROM groupz;";
    private static final String SQL_UPDATE_GROUPZ = "UPDATE groupz SET group_note = ?, department_id = ? WHERE group_id = ?;";
    private static final String SQL_DELETE_FROM_GROUPZ = "DELETE FROM groupz WHERE group_id = ?;";
    private static final String SQL_INSERT_INTO_GROUPZ = "INSERT INTO groupz (group_note, department_id) VALUES (?, ?);";
    private static final String SQL_SELECT_GROUP_BY_ID = "SELECT * FROM groupz where group_id = ?";
    private static final String SQL_INSERT_GROUP_STUDENT = "INSERT INTO group_student (group_id, student_id) VALUES(?, ?)";
    private static final String SQL_SELECT_STUDENT_BY_GROUP = "SELECT student_id FROM group_student WHERE group_id = ?";
    private static final String SQL_DELETE_GROUP_STUDENT = "DELETE FROM group_student WHERE group_id = ?;";
    private static final String SEPARATOR = "|";

    @Autowired
    public GroupDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() throws GroupDAOException {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_GROUPZ, Integer.class);
    }

    public Group getById(Integer id) throws GroupDAOException {
        return jdbcTemplate.queryForObject(SQL_SELECT_GROUP_BY_ID, new Object[] { id },
                new GroupMapper());
    }

    public boolean delete(Group group) throws GroupDAOException {
        return jdbcTemplate.update(SQL_DELETE_FROM_GROUPZ, group.getId()) > 0;
    }

    public boolean update(Integer id, Group group) throws GroupDAOException {
        StringBuffer notes = new StringBuffer();
        group.getSpecialNotes()
                .forEach(listItem -> notes.append(listItem).append(SEPARATOR));

        return jdbcTemplate.update(SQL_UPDATE_GROUPZ, notes.toString(),
                group.getDepartmentId(), group.getId()) > 0;
    }

    public boolean create(Group group) throws GroupDAOException {
        return jdbcTemplate.update(SQL_INSERT_INTO_GROUPZ, group.getSpecialNotes(),
                group.getDepartmentId()) > 0;
    }

    public boolean setGroupStudent(Group group, List<Student> students)
            throws GroupDAOException {
        // TODO: Make it batch.
        boolean result = false;
        for (int i = 0; i < students.size(); i++) {
            jdbcTemplate.update(SQL_INSERT_GROUP_STUDENT, group.getId(),
                    students.get(0).getId());
        }
        return result;
    }

    public boolean deleteGroupStudent(Group group) throws GroupDAOException {
        return 0 < jdbcTemplate.update(SQL_DELETE_GROUP_STUDENT, group.getId());
    }

    public List<Student> getStudentsByGroup(Group group) throws GroupDAOException, StudentDAOException {
        List<Integer> studentIds = jdbcTemplate.queryForList(SQL_SELECT_STUDENT_BY_GROUP,
                Integer.class, group.getId());
        List<Student> students = new ArrayList<>();
        for (Integer studentId : studentIds) {
            students.add(studentdao.getById(studentId));
        }
        return students;
    }

}