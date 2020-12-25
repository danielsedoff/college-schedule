package com.danielsedoff.college.schedule.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DAO;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.model.YearSchedule;
import com.danielsedoff.college.schedule.service.CourseService;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.LessonService;
import com.danielsedoff.college.schedule.service.ProfessorService;
import com.danielsedoff.college.schedule.service.StudentService;

@Profile("test")
@Configuration
@ContextConfiguration
//@ComponentScan(basePackages = { "com.danielsedoff.college.schedule" })
public class TestConfig { // extends WebConfig {

    @Bean
    Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "sa");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return properties;
    }

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException, SQLException {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        DataSource dataSource = dataSource();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[] { "com.danielsedoff.college.schedule.model" });
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(getProperties());
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public WebApplicationContext getwac() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        return context;
    }

    @Bean
    public CourseService courseService() {
        return Mockito.mock(CourseService.class);
    }

    @Bean
    public GroupService groupService() {
        return Mockito.mock(GroupService.class);
    }

    @Bean
    public LessonService lessonService() {
        return Mockito.mock(LessonService.class);
    }

    @Bean
    public ProfessorService professorService() {
        return Mockito.mock(ProfessorService.class);
    }

    @Bean
    public StudentService studentService() {
        return Mockito.mock(StudentService.class);
    }

    @Bean
    public DAO<Course> getCourseDAO() {
        return new CourseDAO();
    }

    @Bean
    public DAO<Group> getGroupDAO() {
        return new GroupDAO();
    }

    @Bean
    public DAO<Student> getStudentDAO() {
        return new StudentDAO();
    }

    @Bean
    public DAO<Professor> getProfessorDAO() {
        return new ProfessorDAO();
    }

    @Bean
    public DAO<Lesson> getLessonDAO() {
        return new LessonDAO();
    }

    @Bean
    public DAO<DaySchedule> getDayScheduleDAO() {
        return new DayScheduleDAO();
    }

    @Bean
    public DAO<YearSchedule> getYearScheduleDAO() {
        return new YearScheduleDAO();
    }

}
