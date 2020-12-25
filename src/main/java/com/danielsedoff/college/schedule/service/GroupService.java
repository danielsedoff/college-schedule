package com.danielsedoff.college.schedule.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.GroupRepository;
import com.danielsedoff.college.schedule.model.Group;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupdao;

    private static Logger logger = LoggerFactory.getLogger(GroupService.class);

    public boolean createGroup(Group group) {
        return groupdao.save(group) != null;
    }

    public Group getGroupById(int groupId) {
        Optional<Group> result = groupdao.findById(groupId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteGroupById(int groupId) {
        try {
            groupdao.deleteById(groupId);
        } catch (Exception e) {
            logger.error("Could not delete Group by id: {}", groupId);
            return false;
        }
        return true;
    }

    public boolean updateGroup(int groupId, Group group) {
        try {
            Group managedGroup = groupdao.findById(groupId).get();
            managedGroup.setStudents(group.getStudents());
            managedGroup.setSpecialNotes(group.getSpecialNotes());
            groupdao.save(managedGroup);
        } catch (Exception e) {
            logger.error("Could not update Group, id: {}", groupId);
            return false;
        }
        return true;
    }

    public List<Group> getGroupList() {
        try {
            return (List<Group>) groupdao.findAll();
        } catch (Exception e) {
            logger.error("Could not get a Group List", e);
        }
        return null;
    }

}
