package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.DaySchedule;

@Aspect
@Component
public class DayScheduleDAO implements DAO<DaySchedule> {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (DaySchedule daySchedule : getList()) {
                result.add(daySchedule.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule Id List", e);
        }
        return result;
    }

    @Transactional
    public DaySchedule getById(Integer id) throws DAOException {
        DaySchedule result = null;
        try {
            result = em.find(DaySchedule.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule By Id", e);
        }
        return result;
    }

    @Transactional
    public boolean delete(DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            DaySchedule targetDaySchedule = em.find(DaySchedule.class, daySchedule.getId());
            em.remove(targetDaySchedule);
        } catch (Exception e) {
            throw new DAOException("Could not delete DaySchedule", e);
        }
        return result;
    }

    @Transactional
    public boolean update(Integer id, DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            DaySchedule oldDaySchedule = (DaySchedule) em.find(DaySchedule.class, id);
            oldDaySchedule.setDay(daySchedule.getDay());
            oldDaySchedule.setHasOverlaps(daySchedule.getHasOverlaps());
        } catch (Exception e) {
            throw new DAOException("Could not update DaySchedule", e);
        }
        return result;
    }

    @Transactional
    public boolean create(DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            em.persist(daySchedule);
        } catch (Exception e) {
            throw new DAOException("Could not create DaySchedule", e);
        }
        return result;
    }

    @Transactional
    public List<DaySchedule> getList() throws DAOException {
        List<DaySchedule> daySchedules = null;
        try {
            daySchedules = em.createQuery("from DaySchedule", DaySchedule.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule List", e);
        }
        return daySchedules;
    }
}
