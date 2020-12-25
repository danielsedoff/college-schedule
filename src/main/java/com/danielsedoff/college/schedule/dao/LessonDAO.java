package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
public class LessonDAO implements DAO<Lesson> {
    public List<Lesson> getList() throws DAOException {
        List<Lesson> lessons = null;
        try {
            SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            lessons = session.createQuery("From Lesson").list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Could not get Lesson Id List", e);
            
        }
        return lessons;
    }

    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            List<Lesson> lessons = (List<Lesson>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From Lesson").list();
            for (Lesson lesson : lessons) {
                result.add(lesson.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Lesson Id List", e);
        }
        return result;
    }

    public Lesson getById(Integer id) throws DAOException {
        Lesson result = null;
        try {
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Lesson.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Lesson By Id", e);
        }
        return result;
    }

    public boolean delete(Lesson lesson) throws DAOException {

        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(lesson);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Lesson", e);
        }
        return result;
    }

    public boolean update(Integer id, Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            lesson.setId(id);
            session.update(lesson);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Lesson", e);
        }
        return result;
    }

    public boolean create(Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.saveOrUpdate(lesson);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Lesson", e);
        }
        return result;

    }

}
