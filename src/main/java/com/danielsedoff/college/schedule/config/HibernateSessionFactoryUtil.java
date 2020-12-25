package com.danielsedoff.college.schedule.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.model.YearSchedule;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    private static Logger logger = LoggerFactory.getLogger(HibernateSessionFactoryUtil.class);

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(DaySchedule.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Lesson.class);
                configuration.addAnnotatedClass(Professor.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(YearSchedule.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                logger.error("HibernateSessionFactoryUtil error: " + e.getMessage());
                //////////////////////////////////////////// DEBUG
                System.out.println("HibernateSessionFactoryUtil error: ");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}