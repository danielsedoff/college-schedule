package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.repositories.CourseRepository;

@SpringBootTest
class CourseServiceTest extends AbstractServiceTest {

    CourseRepository courseRepo = Mockito.mock(CourseRepository.class);

    @Autowired
    CourseService cservice = new CourseService();

    @Test
    void testCreateCourse() throws Exception {
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(courseRepo.save(Mockito.any())).thenReturn(true);
        boolean successfulCreation = cservice.createCourse(course);
        assertTrue(successfulCreation);
    }

    @Test
    void testGetCourseById() throws Exception {
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(courseRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(course));
        assertNotNull(cservice.getCourseById(1));
    }

    @Test
    void testDeleteCourseById() throws Exception {
        courseRepo.delete(Mockito.any());
        boolean successfulDeletion = cservice.deleteCourseById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateCourse() throws Exception {
        int courseId = 1;
        Course course = new Course();
        course.setName("Wine Studies");
        boolean successfulUpdate = cservice.updateCourse(courseId, course);
        assertTrue(successfulUpdate);
    }

}
