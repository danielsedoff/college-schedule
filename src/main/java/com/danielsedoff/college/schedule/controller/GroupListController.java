package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.service.GroupService;

@Controller
@ResponseBody
public class GroupListController {

    @Autowired
    private GroupDAO groupdao;
    @Autowired
    private StudentDAO studentdao;

    @GetMapping("/groups")
    public String example() {
        GroupService gs = new GroupService(groupdao, studentdao);
        List<Integer> ids = gs.getGroupIdList();
        StringBuilder result = new StringBuilder();
        result.append("<!DOCTYPE HTML><HTML><BODY><DIV STYLE=\"font-size:24px;\">");
        result.append("<A HREF=\"index.html\">Back to the index page</A><UL>");
        for (Integer id : ids) {
            result.append("<LI>GroupID ");
            result.append(id);
            result.append(": ");
            result.append(gs.getGroupById(id).getDepartmentId());
            result.append("</LI>");
        }
        result.append("</UL></DIV></BODY></HTML>");
        return result.toString();
    }
}
