package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Professor;

class ProfessorServiceTest {

    ProfessorDAO profdao = Mockito.mock(ProfessorDAO.class);
    ProfessorService profservice = new ProfessorService(profdao);

    @Test
    void testUpdateProfessor() {
        int profId = 1;
        Professor prof = new Professor();
        prof.setName("John");
        Mockito.when(profdao.update(profId, prof)).thenReturn(true);
        boolean successfulUpdate = profservice.updateProfessor(profId, prof);
        assertTrue(successfulUpdate);
    }

    @Test
    void testCreateProfessor() {
        Professor professor = new Professor();
        professor.setName("Jack");
        Mockito.when(profdao.create(professor)).thenReturn(true);
        boolean successfulCreation = profservice.createProfessor(professor);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteProfessor() {
        Mockito.when(profdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = profservice.deleteProfessor(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetProfessorById() {
        Professor professor = new Professor();
        professor.setName("John");
        Mockito.when(profdao.getById(Mockito.anyInt())).thenReturn(professor);
        assertNotNull(profservice.getProfessorById(1));
    }

    @Test
    void testGetProfessorIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(profdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = profservice.getProfessorIdList();
        assertNotNull(idList);
    }

}
