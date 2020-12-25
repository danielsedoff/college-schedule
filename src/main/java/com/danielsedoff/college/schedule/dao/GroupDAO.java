package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Group;

@Component
public class GroupDAO implements DAO<Group> {

    @Autowired
    public GroupDAO groupdao;

    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<Group> groups = em.createQuery("from Group")
                    .getResultList();
            em.getTransaction().commit();

            for (Group group : groups) {
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
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            EntityManager em = emf.createEntityManager();
            result = em.find(Group.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Group By Id", e);
        }
        return result;
    }

    public boolean delete(Group group) throws DAOException {

        boolean result = false;
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
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

            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Group oldGroup = (Group) em.find(Group.class, id);
            oldGroup.setDepartmentId(group.getDepartmentId());
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
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
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
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
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