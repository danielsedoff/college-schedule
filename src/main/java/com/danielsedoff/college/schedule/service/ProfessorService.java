package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class ProfessorService {
    private ProfessorDAO professordao;

    @Autowired
    public ProfessorService(ProfessorDAO professordao) {
        this.professordao = professordao;
    }

    private static Logger logger = LoggerFactory.getLogger(ProfessorService.class);

    public boolean updateProfessor(int professorId, Professor professor) {
        boolean result = false;
        try {
            result = professordao.update(professorId, professor);
        } catch (DAOException e) {
            logger.error("Could not Update a Professor", e);
        }
        return result;
    }

    public boolean createProfessor(Professor professor) {
        boolean result = false;
        try {
            result = professordao.create(professor);
        } catch (DAOException e) {
            logger.error("Could not Create a Professor", e);
        }
        return result;
    }

    public boolean deleteProfessor(int profId) {
        boolean result = false;
        try {
            result = professordao.delete(professordao.getById(profId));
        } catch (DAOException e) {
            logger.error("Could not delete a Professor", e);
        }
        return result;
    }

    public Professor getProfessorById(int professorId) {
        Professor result = null;
        try {
            result = professordao.getById(professorId);
        } catch (DAOException e) {
            logger.error("Could not get a Professor By Id", e);
        }
        return result;
    }

    public List<Integer> getProfessorIdList() {
        List<Integer> result = null;
        try {
            result = professordao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get a Professor Id List", e);
        }
        return result;
    }

}