package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.Course;

@Component
public class CourseDAO implements DAO<Course> {
    
    @Autowired
    public CourseDAO coursedao;
    
    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            List<Course> courses = (List<Course>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From Course").list();
            for (Course course : courses) {
                result.add(course.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Course Id List", e);
        }
        return result;
    }

    public Course getById(Integer id) throws DAOException {
        Course result = null;
        try {
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Course.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Course By Id", e);
        }
        return result;
    }

    public boolean delete(Course course) throws DAOException {

        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(course);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Course", e);
        }
        return result;
    }

    public boolean update(Integer id, Course course) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            course.setId(id);
            session.update(course);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Course", e);
        }
        return result;
    }

    public boolean create(Course course) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(course);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Course", e);
        }
        return result;

    }

}