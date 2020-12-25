package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = null;
        try {
            result = jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_GROUPZ, Integer.class);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public Group getById(Integer id) throws DAOException {
        Group result = null;
        try {
            result = jdbcTemplate.queryForObject(SQL_SELECT_GROUP_BY_ID,
                    new Object[] { id }, new GroupMapper());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public boolean delete(Group group) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_DELETE_FROM_GROUPZ, group.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public boolean update(Integer id, Group group) throws DAOException {
        boolean result = false;
        StringBuilder notes = new StringBuilder();
        group.getSpecialNotes()
                .forEach(listItem -> notes.append(listItem).append(SEPARATOR));

        try {
            result = jdbcTemplate.update(SQL_UPDATE_GROUPZ, notes.toString(),
                    group.getDepartmentId(), group.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean create(Group group) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_INSERT_INTO_GROUPZ, group.getSpecialNotes(),
                    group.getDepartmentId()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean setGroupStudent(Group group, List<Student> students)
            throws DAOException {
        // TODO: Make it batch.
        boolean result = false;
        try {
            for (int i = 0; i < students.size(); i++) {
                jdbcTemplate.update(SQL_INSERT_GROUP_STUDENT, group.getId(),
                        students.get(0).getId());
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean deleteGroupStudent(Group group) throws DAOException {
        boolean result = false;
        try {
            result = 0 < jdbcTemplate.update(SQL_DELETE_GROUP_STUDENT, group.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public List<Student> getStudentsByGroup(Group group) throws DAOException {
        List<Student> students = new ArrayList<>();
        try {
            List<Integer> studentIds = jdbcTemplate.queryForList(
                    SQL_SELECT_STUDENT_BY_GROUP, Integer.class, group.getId());
            for (Integer studentId : studentIds) {
                students.add(studentdao.getById(studentId));
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }

        return students;
    }

}