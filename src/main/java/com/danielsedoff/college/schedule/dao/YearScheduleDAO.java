package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.config.HibernateSessionFactoryUtil;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Component
public class YearScheduleDAO implements DAO<YearSchedule> {
    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = new ArrayList<>();
        try {
            List<YearSchedule> yearSchedules = (List<YearSchedule>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                    .createQuery("From YearSchedule").list();
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
            result = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(YearSchedule.class, id);
        } catch (Exception e) {
            throw new DAOException("Could not get YearSchedule By Id", e);
        }
        return result;
    }

    public boolean delete(YearSchedule yearSchedule) throws DAOException {

        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(yearSchedule);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not delete YearSchedule", e);
        }
        return result;
    }

    public boolean update(Integer id, YearSchedule yearSchedule) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            yearSchedule.setId(id);
            session.update(yearSchedule);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not update YearSchedule", e);
        }
        return result;
    }

    public boolean create(YearSchedule yearSchedule) throws DAOException {
        boolean result = false;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.saveOrUpdate(yearSchedule);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            throw new DAOException("Could not create YearSchedule", e);
        }
        return result;

    }
}
