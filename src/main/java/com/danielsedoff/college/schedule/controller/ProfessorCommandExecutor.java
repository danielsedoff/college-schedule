package com.danielsedoff.college.schedule.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class ProfessorCommandExecutor {
    private static final String WRONG_DEPARTMENT_ID = "Wrong Department ID.";
    private static final String WRONG_PROFESSOR_ID = "Wrong Professor ID.";
    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";
    private static final String ARGUMENT_DELIMITER = "|";
    private ProfessorDAO professordao;

    @Autowired
    public ProfessorCommandExecutor(ProfessorDAO professordao) {
        this.professordao = professordao;
    }

    String updateProfessor(String[] arguments) {
        boolean result = false;
        String professorIdStr = arguments[0];
        String deptIdStr = arguments[1];
        String profName = arguments[2];
        List<String> ranksTitles = List.of(arguments[3].split(ARGUMENT_DELIMITER));
        List<String> specialNotes = List.of(arguments[4].split(ARGUMENT_DELIMITER));
        int professorId = -1;
        int deptId = -1;
        try {
            professorId = Integer.parseInt(professorIdStr);
        } catch (Exception e) {
            return WRONG_PROFESSOR_ID;
        }
        try {
            deptId = Integer.parseInt(deptIdStr);
        } catch (Exception e) {
            return WRONG_DEPARTMENT_ID;
        }
        Professor professor = new Professor();
        professor.setDepartmentId(deptId);
        professor.setName(profName);
        professor.setRanksTitles(ranksTitles);
        professor.setSpecialNotes(specialNotes);
        result = professordao.update(professorId, professor);
        return result ? SUCCESS : FAILURE;
    }

    String createProfessor(String[] arguments) {
        boolean result = false;
        String deptIdStr = arguments[0];
        String profName = arguments[1];
        List<String> ranksTitles = List.of(arguments[2].split(ARGUMENT_DELIMITER));
        List<String> specialNotes = List.of(arguments[3].split(ARGUMENT_DELIMITER));
        int deptId = -1;
        try {
            deptId = Integer.parseInt(deptIdStr);
        } catch (Exception e) {
            return WRONG_DEPARTMENT_ID;
        }
        Professor professor = new Professor();
        professor.setDepartmentId(deptId);
        professor.setName(profName);
        professor.setRanksTitles(ranksTitles);
        professor.setSpecialNotes(specialNotes);
        result = professordao.create(professor);
        return result ? SUCCESS : FAILURE;
    }

    String deleteProfessor(String[] arguments) {
        boolean result = false;
        String profIdStr = arguments[0];
        int profId = -1;
        try {
            profId = Integer.parseInt(profIdStr);
        } catch (Exception e) {
            return WRONG_PROFESSOR_ID;
        }
        result = professordao.delete(professordao.getById(profId));
        return result ? SUCCESS : FAILURE;
    }

    String getProfessorById(String[] arguments) {
        String professorIdStr = arguments[0];
        int professorId = -1;
        try {
            professorId = Integer.parseInt(professorIdStr);
        } catch (Exception e) {
            return WRONG_PROFESSOR_ID;
        }
        return professordao.getById(professorId).toString();
    }

    String getProfessorIdList() {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = professordao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }
}