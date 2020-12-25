package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.EntityManagerConfig;
import com.danielsedoff.college.schedule.model.Professor;

@Component
public class ProfessorDAO implements DAO<Professor> {

    @Autowired
    EntityManagerConfig emf;

    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<Professor> professors = em.createQuery("from Professor")
                    .getResultList();
            em.getTransaction().commit();

            for (Professor professor : professors) {
                result.add(professor.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Professor Id List", e);
        }
        return result;
    }

    public Professor getById(Integer id) throws DAOException {
        Professor result = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            result = em.find(Professor.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get Professor By Id", e);
        }
        return result;
    }

    public boolean delete(Professor professor) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            Professor targetProfessor = em.find(Professor.class,
                    professor.getId());
            em.getTransaction().begin();
            em.remove(targetProfessor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete Professor", e);
        }
        return result;
    }

    public boolean update(Integer id, Professor professor) throws DAOException {
        boolean result = false;
        try {

            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            Professor oldProfessor = (Professor) em.find(Professor.class, id);
            oldProfessor.setDepartmentId(professor.getDepartmentId());
            oldProfessor.setName(professor.getName());
            oldProfessor.setRanksTitles(professor.getRanksTitles());
            oldProfessor.setSpecialNotes(professor.getSpecialNotes());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not update Professor", e);
        }
        return result;
    }

    public boolean create(Professor professor) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not create Professor", e);
        }
        return result;

    }

    public List<Professor> getList() throws DAOException {
        List<Professor> professors = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            professors = em.createQuery("from Professor", Professor.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get Professor List", e);
        }
        return professors;
    }

}