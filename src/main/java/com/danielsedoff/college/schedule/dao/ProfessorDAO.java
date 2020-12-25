package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.Professor;

@Component
public class ProfessorDAO implements DAO<Professor> {
    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            List<Professor> professors = (List<Professor>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From Professor").list();
            for (Professor professor : professors) {
                result.add(professor.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Professor Id List", e);
        }
        return result;
    }

    public Professor getById(Integer id) throws DAOException {
        Professor result = null;
        try {
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Professor.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Professor By Id", e);
        }
        return result;
    }

    public boolean delete(Professor professor) throws DAOException {

        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(professor);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Professor", e);
        }
        return result;
    }

    public boolean update(Integer id, Professor professor) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            professor.setId(id);
            session.update(professor);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Professor", e);
        }
        return result;
    }

    public boolean create(Professor professor) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(professor);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Professor", e);
        }
        return result;

    }
}
