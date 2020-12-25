package com.danielsedoff.college.schedule.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.ProfessorRepository;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professordao;

    private static Logger logger = LoggerFactory.getLogger(ProfessorService.class);

    public boolean createProfessor(Professor professor) {
        return professordao.save(professor) != null;
    }

    public Professor getProfessorById(int professorId) {
        Optional<Professor> result = professordao.findById(professorId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteProfessorById(int professorId) {
        try {
            professordao.deleteById(professorId);
        } catch (Exception e) {
            logger.error("Could not delete Professor by id: {}", professorId);
            return false;
        }
        return true;
    }

    public boolean updateProfessor(int professorId, Professor professor) {
        try {
            Professor managedProfessor = professordao.findById(professorId).get();
            managedProfessor.setCourse(professor.getCourse());
            managedProfessor.setLessons(professor.getLessons());
            managedProfessor.setName(professor.getName());
            managedProfessor.setRanksTitles(professor.getRanksTitles());
            managedProfessor.setSpecialNotes(professor.getSpecialNotes());
            professordao.save(managedProfessor);
        } catch (Exception e) {
            logger.error("Could not update Professor, id: {}", professorId);
            return false;
        }
        return true;
    }

    public List<Professor> getProfessorList() {
        try {
            return (List<Professor>) professordao.findAll();
        } catch (Exception e) {
            logger.error("Could not get a Professor List", e);
        }
        return null;
    }

}
