package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.danielsedoff.college.schedule.dto.GroupDTO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.service.GroupService;

@Controller
public class GroupWebController {

    @Autowired
    private GroupService gs;

    @GetMapping("/groupList")
    public String getGroups(Model model) {
        List<Group> groups = gs.getGroupList();
        model.addAttribute("groups", groups);
        model.addAttribute("testvalue", "passed");
        return "groupList";
    }

    @RequestMapping(value = "/groupForm", params = { "id" }, method = RequestMethod.GET)
    public String gedItParam(@RequestParam("id") int id,
            @ModelAttribute("groupdto") GroupDTO groupdto, Model model) {
        if (id == -1) {
            groupdto.setMode("create");
            return "groupForm";
        }

        Group group = gs.getGroupById(id);
        groupdto.setId(id);
        groupdto.setMode("update");
        groupdto.setDescription(group.getSpecialNotes().toString());
        model.addAttribute("testvalue", "passed");
        return "groupForm";
    }

    @PostMapping("/deleteGroup")
    public String deleteGroup(@ModelAttribute("groupdto") GroupDTO groupdto, Model model) {
        gs.deleteGroupById(groupdto.getId());
        model.addAttribute("result", "Your DELETE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/createGroup")
    public String createGroup(@ModelAttribute("groupdto") GroupDTO groupdto, Model model) {
        Group group = new Group();
        group.setSpecialNotes(groupdto.getDescription());
        gs.createGroup(group);
        model.addAttribute("result", "Your CREATE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/updateGroup")
    public String updateGroup(@ModelAttribute("groupdto") GroupDTO groupdto, Model model) {
        Group group = new Group();

        group.setId(groupdto.getId());
        group.setSpecialNotes(groupdto.getDescription());
        gs.updateGroup(groupdto.getId(), group);
        model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
        return "resultPage";
    }
}
