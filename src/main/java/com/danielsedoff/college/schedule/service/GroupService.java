package com.danielsedoff.college.schedule.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.repositories.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepo;

    private static Logger logger = LoggerFactory.getLogger(GroupService.class);

    public boolean createGroup(Group group) {
        return groupRepo.save(group) != null;
    }

    public Group getGroupById(int groupId) {
        Optional<Group> result = groupRepo.findById(groupId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteGroupById(int groupId) {
        try {
            groupRepo.deleteById(groupId);
        } catch (Exception e) {
            logger.error("Could not delete Group by id: {}", groupId);
            return false;
        }
        return true;
    }

    public boolean updateGroup(int groupId, Group group) {
        try {
            Group managedGroup = groupRepo.findById(groupId).get();
            managedGroup.setStudents(group.getStudents());
            managedGroup.setSpecialNotes(group.getSpecialNotes());
            groupRepo.save(managedGroup);
        } catch (Exception e) {
            logger.error("Could not update Group, id: {}", groupId);
            return false;
        }
        return true;
    }

    public List<Group> getGroupList() {
        try {
            return (List<Group>) groupRepo.findAll();
        } catch (Exception e) {
            logger.error("Could not get a Group List", e);
        }
        return null;
    }

}
