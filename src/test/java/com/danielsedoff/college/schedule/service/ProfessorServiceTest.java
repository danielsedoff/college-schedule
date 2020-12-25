package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.repositories.ProfessorRepository;

@SpringBootTest
class ProfessorServiceTest extends AbstractServiceTest {

    ProfessorRepository profRepo = Mockito.mock(ProfessorRepository.class);

    @Autowired
    ProfessorService profservice = new ProfessorService();

    @Test
    void testCreateProfessor() throws Exception {
        Professor professor = new Professor();
        professor.setName("Jack");
        Mockito.when(profRepo.save(Mockito.any())).thenReturn(true);
        boolean successfulCreation = profservice.createProfessor(professor);
        assertTrue(successfulCreation);
    }

    @Test
    void testGetProfessorById() throws Exception {
        Professor professor = new Professor();
        professor.setName("John");
        Mockito.when(profRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(professor));
        assertNotNull(profservice.getProfessorById(1));
    }

    @Test
    void testDeleteProfessor() throws Exception {
        profRepo.delete(Mockito.any());
        boolean successfulDeletion = profservice.deleteProfessorById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateProfessor() throws Exception {
        int profId = 1;
        Professor prof = new Professor();
        prof.setName("John");
        boolean successfulUpdate = profservice.updateProfessor(profId, prof);
        assertTrue(successfulUpdate);
    }

}
