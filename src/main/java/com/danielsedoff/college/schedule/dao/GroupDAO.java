package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Group;

@Component
public class GroupDAO implements DAO<Group> {
    @PersistenceContext
    private EntityManager em;

    @Transactional
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

    @Transactional
    public Group getById(Integer id) throws DAOException {
        Group result = null;
        try {

            result = em.find(Group.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Group By Id", e);
        }
        return result;
    }

    @Transactional
    public boolean delete(Group group) throws DAOException {

        boolean result = false;
        try {

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

    @Transactional
    public boolean update(Integer id, Group group) throws DAOException {
        boolean result = false;
        try {

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

    @Transactional
    public boolean create(Group group) throws DAOException {
        boolean result = false;
        try {

            em.getTransaction().begin();
            em.persist(group);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Group", e);
        }
        return result;

    }

    @Transactional
    public List<Group> getList() throws DAOException {
        List<Group> groups = null;
        try {

            em.getTransaction().begin();
            groups = em.createQuery("from Group", Group.class).getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get Group List", e);
        }
        return groups;
    }

}