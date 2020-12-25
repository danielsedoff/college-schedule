package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.EntityManagerConfig;
import com.danielsedoff.college.schedule.model.Student;

@Component
public class StudentDAO implements DAO<Student> {

    @Autowired
    EntityManagerConfig emf;
    
    private static Logger logger = LoggerFactory.getLogger(StudentDAO.class);


    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Student student : getList()) {
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
            EntityManager em = emf.getFactory().createEntityManager();
            result = em.find(Student.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Student By Id", e);
        }
        return result;
    }

    public boolean delete(Student student) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            Student targetStudent = em.find(Student.class, student.getId());
            em.getTransaction().begin();
            em.remove(targetStudent);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Student", e);
        }
        return result;
    }

    public boolean update(Integer id, Student student) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            Student oldStudent = (Student) em.find(Student.class, id);
            oldStudent.setGroup(student.getGroup());
            oldStudent.setName(student.getName());
            oldStudent.setSchoolYear(student.getSchoolYear());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Student", e);
        }
        return result;
    }

    public boolean create(Student student) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(student);
            em.close();
        } catch (Exception e) {
            e.printStackTrace();// DEBUG if logger failed
            logger.error(e.getStackTrace().toString());
            throw new DAOException("Could not create Student", e);
        }
        return result;

    }

    public List<Student> getList() throws DAOException {
        List<Student> students = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            students = em.createQuery("from Student", Student.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get Student List", e);
        }
        return students;
    }

}