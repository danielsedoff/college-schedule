package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Professor;

@Transactional @Component 
public class ProfessorDAO extends EntityManagedDAO implements DAO<Professor> {

    private static Logger logger = LoggerFactory.getLogger(ProfessorDAO.class);

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (Professor professor : getList()) {
                result.add(professor.getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Professor Id List", e);
        }
        return result;
    }

    public Professor getById(Integer id) throws DAOException {
        Professor result = null;
        try {
            EntityManager em = getEntityManagerBean();
            result = em.find(Professor.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Professor By Id", e);
        }
        return result;
    }

    public boolean delete(Professor professor) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            em.getTransaction().commit();
            Professor targetProfessor = em.find(Professor.class, professor.getId());
            em.getTransaction().begin();
            em.remove(targetProfessor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not delete Professor", e);
        }
        return result;
    }

    public boolean update(Integer id, Professor professor) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            Professor oldProfessor = (Professor) em.find(Professor.class, id);
            oldProfessor.setName(professor.getName());
            oldProfessor.setRanksTitles(professor.getRanksTitles());
            oldProfessor.setSpecialNotes(professor.getSpecialNotes());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not update Professor", e);
        }
        return result;
    }

    public boolean create(Professor professor) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not create Professor", e);
        }
        return result;

    }

    public List<Professor> getList() throws DAOException {
        List<Professor> professors = null;
        try {
            EntityManager em = getEntityManagerBean();
            em.getTransaction().begin();
            professors = em.createQuery("from Professor", Professor.class).getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DAOException("Could not get Professor List", e);
        }
        return professors;
    }

}