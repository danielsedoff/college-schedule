package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.EntityManagerConfig;
import com.danielsedoff.college.schedule.model.Course;

@Component
public class CourseDAO implements DAO<Course> {

    private static Logger logger = LoggerFactory.getLogger(CourseDAO.class);
    
    @Autowired
    EntityManagerConfig emf;

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Course course : getList()) {
                result.add(course.getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Course Id List", e);
        }
        return result;
    }

    public Course getById(Integer id) throws DAOException {
        Course result = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            result = em.find(Course.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Course By Id", e);
        }
        return result;
    }

    public boolean delete(Course course) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            Course targetCourse = em.find(Course.class, course.getId());
            em.getTransaction().begin();
            em.remove(targetCourse);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not delete Course", e);
        }
        return result;
    }

    public boolean update(Integer id, Course course) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            Course oldCourse = (Course) em.find(Course.class, id);
            oldCourse.setCourseDescription(course.getCourseDescription());
            oldCourse.setName(course.getName());
            oldCourse.setProfessorId(course.getProfessorId());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not update Course", e);
        }
        return result;
    }

    public boolean create(Course course) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            em.flush();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not create Course", e);
        }
        return result;

    }

    public List<Course> getList() throws DAOException {
        List<Course> courses = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            courses = em.createQuery("from Course", Course.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Course List", e);
        }
        return courses;
    }

}