package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.DaySchedule;

@Component
public class DayScheduleDAO implements DAO<DaySchedule> {
    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            List<DaySchedule> daySchedules = (List<DaySchedule>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From DaySchedule").list();
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
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DaySchedule.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get DaySchedule By Id", e);
        }
        return result;
    }

    public boolean delete(DaySchedule daySchedule) throws DAOException {

        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(daySchedule);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete DaySchedule", e);
        }
        return result;
    }

    public boolean update(Integer id, DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            daySchedule.setId(id);
            session.update(daySchedule);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update DaySchedule", e);
        }
        return result;
    }

    public boolean create(DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(daySchedule);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not create DaySchedule", e);
        }
        return result;

    }
}
