package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Group;

@Transactional @Component 
public class GroupDAO extends EntityManagedDAO implements DAO<Group> {

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Group group : getList()) {
                result.add(group.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Group Id List", e);
        }
        return result;
    }

    public Group getById(Integer id) throws DAOException {
        Group result = null;
        try {
            EntityManager em = getEntityManagerBean();
            result = em.find(Group.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Group By Id", e);
        }
        return result;
    }

    public boolean delete(Group group) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            em.getTransaction().commit();
            Group targetGroup = em.find(Group.class, group.getId());
            em.getTransaction().begin();
            em.remove(targetGroup);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Group", e);
        }
        return result;
    }

    public boolean update(Integer id, Group group) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            Group oldGroup = (Group) em.find(Group.class, id);
            oldGroup.setSpecialNotes(group.getSpecialNotes());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Group", e);
        }
        return result;
    }

    public boolean create(Group group) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            em.persist(group);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Group", e);
        }
        return result;

    }

    public List<Group> getList() throws DAOException {
        List<Group> groups = null;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            groups = em.createQuery("from Group", Group.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get Group List", e);
        }
        return groups;
    }

}