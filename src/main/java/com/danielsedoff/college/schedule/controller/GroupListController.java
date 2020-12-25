package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.service.GroupService;

@Controller
public class GroupListController {

    @Autowired
    private GroupService gs;

    @GetMapping("/groupList")
    public String getGroups(Model model) {
        List<Integer> ids = gs.getGroupIdList();
        List<Group> groups = new ArrayList<>();

        for (int id : ids) {
            groups.add(gs.getGroupById(id));
        }
        model.addAttribute("groups", groups);
        model.addAttribute("testvalue", "passed");
        return "groupList";
    }

}
