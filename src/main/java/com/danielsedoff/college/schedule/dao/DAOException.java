package com.danielsedoff.college.schedule.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOException extends Exception {
    private static final long serialVersionUID = -7426338758158922269L;

    public class CourseDAOException extends DAOException {
        private static final long serialVersionUID = -3864421719965965531L;

        public CourseDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(CourseDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }

    }

    public class DayScheduleDAOException extends DAOException {
        private static final long serialVersionUID = 1854647177063031715L;

        public DayScheduleDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(DayScheduleDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }

    }

    public class GroupDAOException extends DAOException {
        private static final long serialVersionUID = -2691139832821765335L;

        public GroupDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(GroupDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }
    }

    public class LessonDAOException extends DAOException {
        private static final long serialVersionUID = 6109882739625846946L;

        public LessonDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(LessonDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }
    }

    public class ProfessorDAOException extends DAOException {
        private static final long serialVersionUID = 4935769721493931751L;

        public ProfessorDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(ProfessorDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }
    }

    public class StudentDAOException extends DAOException {
        private static final long serialVersionUID = 7040483997142421721L;

        public StudentDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(StudentDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }
    }

    public class YearScheduleDAOException extends DAOException {
        private static final long serialVersionUID = -6957786583911475516L;

        public YearScheduleDAOException() {
            super();
            Logger logger = LoggerFactory.getLogger(YearScheduleDAOException.class);
            logger.debug(this.getStackTrace().toString(), this.getClass());
        }
    }

}
