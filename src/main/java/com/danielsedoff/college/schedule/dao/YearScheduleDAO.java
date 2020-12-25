package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.danielsedoff.college.schedule.model.YearSchedule;

@Aspect
@Transactional
@Component
public class YearScheduleDAO implements DAO<YearSchedule> {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = new ArrayList<>();
        try {
            for (YearSchedule yearSchedule : getList()) {
                result.add(yearSchedule.getId());
            }
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule Id List", e);
        }
        return result;
    }

    @Transactional(readOnly=true)
    public YearSchedule getById(Integer id) throws DAOException {
        YearSchedule result = null;
        try {
            result = em.find(YearSchedule.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule By Id", e);
        }
        return result;
    }

    public boolean delete(YearSchedule yearSchedule) throws DAOException {
        boolean result = false;
        try {
            YearSchedule targetYearSchedule = em.find(YearSchedule.class, yearSchedule.getId());
            em.remove(targetYearSchedule);
        } catch (Exception e) {
            throw new DAOException("Could not delete YearSchedule", e);
        }
        return result;
    }

    public boolean update(Integer id, YearSchedule yearSchedule) throws DAOException {
        boolean result = false;
        try {
            YearSchedule oldYearSchedule = (YearSchedule) em.find(YearSchedule.class, id);
            oldYearSchedule.setYear(yearSchedule.getYear());
        } catch (Exception e) {
            throw new DAOException("Could not update YearSchedule", e);
        }
        return result;
    }

    public boolean create(YearSchedule yearSchedule) throws DAOException {
        boolean result = false;
        try {
            em.persist(yearSchedule);
        } catch (Exception e) {
            throw new DAOException("Could not create YearSchedule", e);
        }
        return result;
    }

    @Transactional(readOnly=true)
    public List<YearSchedule> getList() throws DAOException {
        List<YearSchedule> yearSchedules = null;
        try {
            yearSchedules = em.createQuery("from YearSchedule", YearSchedule.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule List", e);
        }
        return yearSchedules;
    }
}
