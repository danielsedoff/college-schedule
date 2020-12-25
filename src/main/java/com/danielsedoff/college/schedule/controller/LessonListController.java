package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.service.LessonService;

@Controller
@ResponseBody
public class LessonListController {

    @Autowired
    private GroupDAO groupdao;
    @Autowired
    private LessonDAO lessondao;
    @Autowired
    private ProfessorDAO professordao;

    @GetMapping("/lessons")
    public String example() {
        LessonService gs = new LessonService(professordao, lessondao, groupdao);
        List<Integer> ids = gs.getLessonIdList();
        StringBuilder result = new StringBuilder();
        result.append("<!DOCTYPE HTML><HTML><BODY><DIV STYLE=\"font-size:24px;\">");
        result.append("<A HREF=\"index.html\">Back to the index page</A><UL>");
        for (Integer id : ids) {
            result.append("<LI>Lesson ID ");
            result.append(id);
            result.append(": ");
            result.append(gs.getLessonById(id).getStartTime().toString());
            result.append(" - ");
            result.append(gs.getLessonById(id).getEndTime().toString());
            result.append("</LI>");
        }
        result.append("</UL></DIV></BODY></HTML>");
        return result.toString();
    }
}
