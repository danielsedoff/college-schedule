package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class ProfessorService {
    private ProfessorDAO professordao;

    @Autowired
    public ProfessorService(ProfessorDAO professordao) {
        this.professordao = professordao;
    }

    boolean updateProfessor(int professorId, Professor professor)
             {
        return professordao.update(professorId, professor);
    }

    boolean createProfessor(Professor professor)  {
        return professordao.create(professor);
    }

    boolean deleteProfessor(int profId)  {
        return professordao.delete(professordao.getById(profId));
    }

    Professor getProfessorById(int professorId)  {
        return professordao.getById(professorId);
    }

    List<Integer> getProfessorIdList()  {
        return professordao.getIdList();
    }
}