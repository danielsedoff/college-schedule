package com.danielsedoff.college.schedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Student;
import static com.danielsedoff.college.schedule.lang.UserMessages.*;

@Service
public class StudentService {

    private static final String ARGUMENT_DELIMITER = "|";
    private StudentDAO studentdao;
    private ProfessorDAO professordao;
    private GroupDAO groupdao;

    @Autowired
    public StudentService(ProfessorDAO professordao, StudentDAO studentdao,
            GroupDAO groupdao) {
        this.professordao = professordao;
        this.studentdao = studentdao;
        this.groupdao = groupdao;
    }

    public String getStudentIdList() {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = professordao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String createStudent(String[] arguments) {
        boolean result = false;
        String groupIdStr = arguments[0];
        String yearStr = arguments[1];
        String name = arguments[2];
        List<String> specialNotes = List.of(arguments[3].split(ARGUMENT_DELIMITER));
        int groupId = -1;
        int year = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        try {
            year = Integer.parseInt(yearStr);
        } catch (Exception e) {
            return WRONG_YEAR;
        }

        Student st = new Student();
        st.setGroup(groupdao.getById(groupId));
        st.setSchoolYear(year);
        st.setName(name);
        st.setSpecialNotes(specialNotes);
        result = studentdao.create(st);
        return result ? SUCCESS : FAILURE;
    }

    public String updateStudent(String[] arguments) {
        boolean result = false;
        String studIdStr = arguments[0];
        String groupIdStr = arguments[1];
        String yearStr = arguments[2];
        String name = arguments[3];
        List<String> specialNotes = List.of(arguments[4].split(ARGUMENT_DELIMITER));
        int groupId = -1;
        int studId = -1;
        int year = -1;
        try {
            studId = Integer.parseInt(studIdStr);
        } catch (Exception e) {
            return WRONG_STUDENT_ID;
        }
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        try {
            year = Integer.parseInt(yearStr);
        } catch (Exception e) {
            return WRONG_YEAR;
        }
        Student st = new Student();
        st.setGroup(groupdao.getById(groupId));
        st.setSchoolYear(year);
        st.setName(name);
        st.setSpecialNotes(specialNotes);
        result = studentdao.update(studId, st);
        return result ? SUCCESS : FAILURE;
    }

    public String deleteStudent(String[] arguments) {
        boolean result = false;
        String studIdStr = arguments[0];
        int studId = -1;
        try {
            studId = Integer.parseInt(studIdStr);
        } catch (Exception e) {
            return WRONG_GROUP_ID;
        }
        Student st = studentdao.getById(studId);
        result = studentdao.delete(st);
        return result ? SUCCESS : FAILURE;

    }

    public String getStudentById(String[] arguments) {
        String studIdStr = arguments[0];
        int studId = -1;
        try {
            studId = Integer.parseInt(studIdStr);
        } catch (Exception e) {
            return WRONG_STUDENT_ID;
        }
        Student student = studentdao.getById(studId);
        return student.toString();
    }

}
