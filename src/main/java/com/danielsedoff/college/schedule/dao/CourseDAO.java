package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.danielsedoff.college.schedule.model.Course;

@Transactional
@Component
public class CourseDAO implements DAO<Course> {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Transactional(readOnly=true)
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Course course : getList()) {
                result.add(course.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Course Id List", e);
        }
        return result;
    }

    @Transactional(readOnly=true)
    public Course getById(Integer id) throws DAOException {
        Course result = null;
        try {
            result = em.find(Course.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Course By Id", e);
        }
        return result;
    }

    public boolean delete(Course course) throws DAOException {
        boolean result = false;
        try {
            Course targetCourse = em.find(Course.class, course.getId());
            em.remove(targetCourse);
            em.flush();
            em.clear();
        } catch (Exception e) {
            throw new DAOException("Could not delete Course", e);
        }
        return result;
    }

    public boolean create(Course course) throws DAOException {
        boolean result = false;
        try {
            em.persist(course);
            em.clear();
        } catch (Exception e) {
            throw new DAOException("Could not create Course", e);
        }
        return result;
    }

    public boolean update(Integer id, Course course) throws DAOException {
        boolean result = false;
        try {
            Course newCourse = em.find(Course.class, id);
            newCourse.setCourseDescription(course.getCourseDescription());
            newCourse.setName(course.getName());
            newCourse.setProfessor(course.getProfessors());
        } catch (Exception e) {
            throw new DAOException("Could not update Course", e);
        }
        return result;
    }

    @Transactional(readOnly=true)
    public List<Course> getList() throws DAOException {
        List<Course> courses = null;
        try {
            courses = em.createQuery("from Course", Course.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("Could not get Course List", e);
        }
        return courses;
    }
}
