package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.Group;

public class GroupMapper implements RowMapper<Group> {

    public Group mapRow(ResultSet resultSet, int i) throws SQLException {
        Group group = new Group();
        
        group.setId(resultSet.getInt("group_id"));
        group.setDepartmentId((resultSet.getInt("department_id")));
        group.setSpecialNotes(new ArrayList<>(Arrays.asList(resultSet.getString("group_note").split("\n"))));
        return group;
    }

}
