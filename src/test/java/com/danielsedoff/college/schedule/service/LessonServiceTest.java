package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.repositories.GroupRepository;
import com.danielsedoff.college.schedule.repositories.LessonRepository;
import com.danielsedoff.college.schedule.repositories.ProfessorRepository;

@SpringBootTest
class LessonServiceTest extends AbstractServiceTest {

    ProfessorRepository profRepo = Mockito.mock(ProfessorRepository.class);
    LessonRepository lessonRepo = Mockito.mock(LessonRepository.class);
    GroupRepository groupRepo = Mockito.mock(GroupRepository.class);

    @Autowired
    LessonService lservice;

    @Test
    void testGetLessonById() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lessonRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(lesson));
        assertNotNull(lservice.getLessonById(1));
    }

    @Test
    void testCreateLesson() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setStartTime("12-12-2012");
        Mockito.when(lessonRepo.save(Mockito.any())).thenReturn(true);
        boolean successfulCreation = lservice.createLesson(lesson);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteLessonById() throws Exception {
        lessonRepo.delete(Mockito.any());
        boolean successfulDeletion = lservice.deleteLessonById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateLesson() throws Exception {
        int lessonId = 1;
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        boolean successfulUpdate = lservice.updateLesson(lessonId, lesson);
        assertTrue(successfulUpdate);
    }

}
