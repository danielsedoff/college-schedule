package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.EntityManagerConfig;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Component
public class YearScheduleDAO implements DAO<YearSchedule> {

    @Autowired
    EntityManagerConfig emf;

    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<YearSchedule> yearSchedules = em
                    .createQuery("from YearSchedule").getResultList();
            em.getTransaction().commit();

            for (YearSchedule yearSchedule : yearSchedules) {
                result.add(yearSchedule.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule Id List", e);
        }
        return result;
    }

    public YearSchedule getById(Integer id) throws DAOException {
        YearSchedule result = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            result = em.find(YearSchedule.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule By Id", e);
        }
        return result;
    }

    public boolean delete(YearSchedule yearSchedule) throws DAOException {

        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            YearSchedule targetYearSchedule = em.find(YearSchedule.class,
                    yearSchedule.getId());
            em.getTransaction().begin();
            em.remove(targetYearSchedule);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete YearSchedule", e);
        }
        return result;
    }

    public boolean update(Integer id, YearSchedule yearSchedule)
            throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            YearSchedule oldYearSchedule = (YearSchedule) em
                    .find(YearSchedule.class, id);
            oldYearSchedule.setYear(yearSchedule.getYear());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not update YearSchedule", e);
        }
        return result;
    }

    public boolean create(YearSchedule yearSchedule) throws DAOException {
        boolean result = false;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(yearSchedule);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not create YearSchedule", e);
        }
        return result;

    }

    public List<YearSchedule> getList() throws DAOException {
        List<YearSchedule> yearSchedules = null;
        try {
            EntityManager em = emf.getFactory().createEntityManager();
            em.getTransaction().begin();
            yearSchedules = em
                    .createQuery("from YearSchedule", YearSchedule.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule List", e);
        }
        return yearSchedules;
    }

}