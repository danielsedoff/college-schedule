package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.DaySchedule;

@Component
public class DayScheduleDAO implements DAO<DaySchedule> {

    @Autowired
    public DayScheduleDAO dayScheduledao;

    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<DaySchedule> daySchedules = em.createQuery("from DaySchedule")
                    .getResultList();
            em.getTransaction().commit();

            for (DaySchedule daySchedule : daySchedules) {
                result.add(daySchedule.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule Id List", e);
        }
        return result;
    }

    public DaySchedule getById(Integer id) throws DAOException {
        DaySchedule result = null;
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            EntityManager em = emf.createEntityManager();
            result = em.find(DaySchedule.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule By Id", e);
        }
        return result;
    }

    public boolean delete(DaySchedule daySchedule) throws DAOException {

        boolean result = false;
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            DaySchedule targetDaySchedule= em.find(DaySchedule.class ,daySchedule.getId());
            em.getTransaction().begin();
            em.remove(targetDaySchedule);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete DaySchedule", e);
        }
        return result;
    }

    public boolean update(Integer id, DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {

            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            DaySchedule oldDaySchedule= (DaySchedule)em.find(DaySchedule.class ,id);
            oldDaySchedule.setDay(daySchedule.getDay());
            oldDaySchedule.setHasOverlaps(daySchedule.getHasOverlaps());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not update DaySchedule", e);
        }
        return result;
    }

    public boolean create(DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(daySchedule);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not create DaySchedule", e);
        }
        return result;

    }

    public List<DaySchedule> getList() throws DAOException {
        List<DaySchedule> daySchedules = null;
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("PU");
            // DEBUG System.out.println(emf.getProperties());
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            daySchedules = em.createQuery("from DaySchedule", DaySchedule.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule List", e);
        }
        return daySchedules;
    }

}