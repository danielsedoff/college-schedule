package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.danielsedoff.college.schedule.model.Student;

@Aspect
@Component
public class StudentDAO implements DAO<Student> {
    @PersistenceContext
    private EntityManager em;

    private static Logger logger = LoggerFactory.getLogger(StudentDAO.class);

    @Transactional
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Student student : getList()) {
                result.add(student.getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Student Id List", e);
        }
        return result;
    }

    @Transactional
    public Student getById(Integer id) throws DAOException {
        Student result = null;
        try {
            result = em.find(Student.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Student By Id", e);
        }
        return result;
    }

    @Transactional
    public boolean delete(Student student) throws DAOException {
        boolean result = false;
        try {
            Student targetStudent = em.find(Student.class, student.getId());
            em.remove(targetStudent);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not delete Student", e);
        }
        return result;
    }

    @Transactional
    public boolean update(Integer id, Student student) throws DAOException {
        boolean result = false;
        try {
            Student oldStudent = (Student) em.find(Student.class, id);
            oldStudent.setGroup(student.getGroup());
            oldStudent.setName(student.getName());
            oldStudent.setSchoolYear(student.getSchoolYear());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not update Student", e);
        }
        return result;
    }

    @Transactional
    public boolean create(Student student) throws DAOException {
        boolean result = false;
        try {
            System.out.println("StudentDAO RECEIVES: " + student.toString());
            em.persist(student);
            em.flush();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not create Student", e);
        }
        return result;
    }

    @Transactional
    public List<Student> getList() throws DAOException {
        List<Student> students = null;
        try {
            students = em.createQuery("from Student", Student.class).getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Student List", e);
        }
        return students;
    }
}
