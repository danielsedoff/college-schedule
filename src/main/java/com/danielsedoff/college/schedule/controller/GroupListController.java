package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.service.GroupService;

@Controller
public class GroupListController {

    @Autowired
    private GroupDAO groupdao;
    @Autowired
    private StudentDAO studentdao;

    @GetMapping("/groups")
    public String main(Model model) {
        GroupService gs = new GroupService(groupdao, studentdao);
        List<Integer> ids = gs.getGroupIdList();
        List<Group> groups = new ArrayList<>();

        for (int id : ids) {
            groups.add(gs.getGroupById(id));
        }
        model.addAttribute("groups", groups);
        return "groups.html";
    }

}
