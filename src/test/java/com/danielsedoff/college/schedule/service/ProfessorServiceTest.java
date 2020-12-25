package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.Professor;

class ProfessorServiceTest {

    ProfessorService profservice = Mockito.mock(ProfessorService.class);
    
    @Test
    void testUpdateProfessor() {
        int profId = 1;
        Professor prof = new Professor();
        prof.setName("John");
        Mockito.when(profservice.updateProfessor(profId, prof)).thenReturn(true);
        boolean successfulUpdate = profservice.updateProfessor(profId, prof);
        assertTrue(successfulUpdate);
    }

    @Test
    void testCreateProfessor() {
        Professor professor = new Professor();
        professor.setName("Jack");
        Mockito.when(profservice.createProfessor(professor)).thenReturn(true);
        boolean successfulCreation = profservice.createProfessor(professor);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteProfessor() {
        Mockito.when(profservice.deleteProfessor(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = profservice.deleteProfessor(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetProfessorById() {
        Professor professor = new Professor();
        professor.setName("John");
        Mockito.when(profservice.getProfessorById(Mockito.anyInt())).thenReturn(professor);
        assertNotNull(profservice.getProfessorById(1));
    }

    @Test
    void testGetProfessorIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(profservice.getProfessorIdList()).thenReturn(mockList);
        List<Integer> idList = profservice.getProfessorIdList();
        assertNotNull(idList);
    }

}
