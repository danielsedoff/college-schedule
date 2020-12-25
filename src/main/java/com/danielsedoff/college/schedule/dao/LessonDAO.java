package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Transactional;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Lesson;

@Aspect
@Component
public class LessonDAO implements DAO<Lesson> {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private static Logger logger = LoggerFactory.getLogger(LessonDAO.class);

    @Transactional
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Lesson lesson : getList()) {
                result.add(lesson.getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();

            throw new DAOException("Could not get Lesson Id List", e);
        }
        return result;
    }

    @Transactional
    public Lesson getById(Integer id) throws DAOException {
        Lesson result = null;
        try {
            result = em.find(Lesson.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();

            throw new DAOException("Could not get Lesson By Id", e);
        }
        return result;
    }

    @Transactional
    public boolean delete(Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            Lesson targetLesson = em.find(Lesson.class, lesson.getId());
            em.getTransaction().begin();
            em.remove(targetLesson);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();

            throw new DAOException("Could not delete Lesson", e);
        }
        return result;
    }

    @Transactional
    public boolean update(Integer id, Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            Lesson oldLesson = (Lesson) em.find(Lesson.class, id);
            oldLesson.setEndTime(lesson.getEndTime());
            oldLesson.setStartTime(lesson.getStartTime());
            oldLesson.setProfessor(lesson.getProfessor());
            oldLesson.setGroup(lesson.getGroup());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not update Lesson", e);
        }
        return result;
    }

    @Transactional
    public boolean create(Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            em.persist(lesson);
            em.flush();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not create Lesson", e);
        }
        return result;

    }

    @Transactional
    public List<Lesson> getList() throws DAOException {
        List<Lesson> lessons = null;
        try {
            lessons = em.createQuery("from Lesson", Lesson.class).getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            throw new DAOException("Could not get Lesson List", e);
        }
        return lessons;
    }
}
