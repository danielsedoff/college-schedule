package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class ProfessorService {

    private static Logger logger = LoggerFactory.getLogger(ProfessorService.class);

    private DAO<Professor> profdao;

    public ProfessorService(DAO<Professor> profdao) {
        super();
        this.profdao = profdao;
    }

    public boolean updateProfessor(int professorId, Professor professor) {
        boolean result = false;
        try {
            result = profdao.update(professorId, professor);
        } catch (DAOException e) {
            logger.error("Could not Update a Professor, id: {}", professorId);
        }
        return result;
    }

    public boolean createProfessor(Professor professor) {
        boolean result = false;
        try {
            result = profdao.create(professor);
        } catch (DAOException e) {
            logger.error("Could not Create a Professor", e);
        }
        return result;
    }

    public boolean deleteProfessor(int profId) {
        boolean result = false;
        try {
            result = profdao.delete(profdao.getById(profId));
        } catch (DAOException e) {
            logger.error("Could not delete a Professor, id: {}", profId);
        }
        return result;
    }

    public Professor getProfessorById(int professorId) {
        Professor result = null;
        try {
            result = profdao.getById(professorId);
        } catch (DAOException e) {
            logger.error("Could not get a Professor By id: {}", professorId);
        }
        return result;
    }

    public List<Integer> getProfessorIdList() {
        List<Integer> result = null;
        try {
            result = profdao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get a Professor Id List", e);
        }
        return result;
    }

    public List<Professor> getProfessorList() {
        List<Professor> result = null;
        try {
            result = profdao.getList();
        } catch (DAOException e) {
            logger.error("Could not get a Professor List", e);
        }
        return result;
    }

}
