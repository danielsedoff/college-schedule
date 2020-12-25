package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.danielsedoff.college.schedule.model.Group;

@Transactional
@Component("groupdao")
public class GroupDAO implements DAO<Group> {

    private static Logger logger = LoggerFactory.getLogger(GroupDAO.class);

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Transactional(readOnly=true)
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Group group : getList()) {
                result.add(group.getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not get Group Id List", e);
        }
        return result;
    }

    @Transactional(readOnly=true)
    public Group getById(Integer id) throws DAOException {
        Group result = null;
        try {
            result = em.find(Group.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not get Group By Id", e);
        }
        return result;
    }

    public boolean delete(Group group) throws DAOException {
        boolean result = false;
        try {
            Group targetGroup = em.find(Group.class, group.getId());
            em.remove(targetGroup);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not delete Group", e);
        }
        return result;
    }

    public boolean update(Integer id, Group group) throws DAOException {
        boolean result = false;
        try {
            Group oldGroup = (Group) em.find(Group.class, id);
            oldGroup.setSpecialNotes(group.getSpecialNotes());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not update Group", e);
        }
        return result;
    }

    public boolean create(Group group) throws DAOException {
        boolean result = false;
        try {
            em.persist(group);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not create Group", e);
        }
        return result;

    }

    @Transactional(readOnly=true)
    public List<Group> getList() throws DAOException {
        List<Group> groups = null;
        try {
            groups = em.createQuery("from Group", Group.class).getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not get Group List", e);
        }
        return groups;
    }
}
