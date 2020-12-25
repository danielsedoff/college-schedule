package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.EntityManagerConfig;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
public class LessonDAO implements DAO<Lesson> {

    @Autowired
    EntityManagerConfig emf;

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Lesson lesson : getList()) {
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
            EntityManager em = emf.getFactory().createEntityManager();
            result = em.find(Lesson.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Lesson By Id", e);
        }
        return result;
    }

    public boolean delete(Lesson lesson) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            Lesson targetLesson = em.find(Lesson.class, lesson.getId());
            em.getTransaction().begin();
            em.remove(targetLesson);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Lesson", e);
        }
        return result;
    }

    public boolean update(Integer id, Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            Lesson oldLesson = (Lesson) em.find(Lesson.class, id);
            oldLesson.setEndTime(lesson.getEndTime());
            oldLesson.setStartTime(lesson.getStartTime());
            oldLesson.setProfessorId(lesson.getProfessorId());
            oldLesson.setGroupId(lesson.getGroupId());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Lesson", e);
        }
        return result;
    }

    public boolean create(Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(lesson);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Lesson", e);
        }
        return result;

    }

    public List<Lesson> getList() throws DAOException {
        List<Lesson> lessons = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            lessons = em.createQuery("from Lesson", Lesson.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get Lesson List", e);
        }
        return lessons;
    }

}