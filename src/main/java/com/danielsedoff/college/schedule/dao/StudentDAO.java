package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.Student;

@Component
public class StudentDAO implements DAO<Student> {

    private static Logger logger = LoggerFactory.getLogger(StudentDAO.class);
    
    public List<Student> getList() throws DAOException {
        List<Student> students = null;
        try {
            SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            students = session.createQuery("From Student").list();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not get Student List", e);
        }
        return students;
    }

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            List<Student> students = (List<Student>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From Student").list();
            for (Student student : students) {
                result.add(student.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Student Id List", e);
        }
        return result;
    }

    public Student getById(Integer id) throws DAOException {
        Student result = null;
        try {
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Student By Id", e);
        }
        return result;
    }

    public boolean delete(Student student) throws DAOException {

        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(student);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Student", e);
        }
        return result;
    }

    public boolean update(Integer id, Student student) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            student.setId(id);
            session.update(student);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Student", e);
        }
        return result;
    }

    public boolean create(Student student) throws DAOException {
        boolean result = false;
        try {
            student.setId(0);
            SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.saveOrUpdate(student);
        } catch (Exception e) {
            throw new DAOException("Could not create Student", e);
        }
        return result;

    }
}
