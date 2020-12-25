package com.danielsedoff.college.schedule.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Component
public class GroupDAO implements DAO<Group> {


    public List<Group> getList() throws DAOException {
        List<Group> groups = null;
        try {
            SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            groups = session.createQuery("From Group").list();
        } catch (Exception e) {
            throw new DAOException("Could not get Student Id List", e);
        }
        return groups;
    }
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = null;
        try {
            List<Group> groups = (List<Group>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From Group").list();
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
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Group By Id", e);
        }
        return result;

    }

    public boolean delete(Group group) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(group);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new DAOException("Could not delete Group", e);
        }
        return result;

    }

    public boolean update(Integer id, Group group) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            group.setId(id);
            session.update(group);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Group", e);
        }
        return result;
    }

    public boolean create(Group group) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(group);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Group", e);
        }
        return result;
    }


}
