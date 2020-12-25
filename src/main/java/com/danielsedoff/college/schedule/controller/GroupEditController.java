package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.service.GroupService;

@Controller
public class GroupEditController {

    @Autowired
    private GroupService gs;

    @RequestMapping(value = "/groupForm", params = { "id" }, method = RequestMethod.GET)
    public String gedItParam(@RequestParam("id") int id, Model model) {

        if (id == -1) {
            return "groupForm";
        }

        Group group = gs.getGroupById(id);
        model.addAttribute("id", id);
        model.addAttribute("description", group.getSpecialNotes().toString());
        model.addAttribute("testvalue", "passed");
        return "groupForm";
    }

    String getParam(String haystack, String needle) {
        int startPosition = haystack.indexOf(needle + "=");
        if (startPosition == -1) {
            return null;
        }
        int endPosition = haystack.indexOf("&", startPosition);
        if ((endPosition == -1) || (endPosition - startPosition < 1)) {
            return null;
        }
        String result = haystack.substring(startPosition + needle.length() + 1, endPosition);
        return result;
    }

    @PostMapping("/groupForm")
    @ResponseBody
    public String editGroups(HttpServletRequest request, HttpServletResponse response,
            Model model) {

        String userRequest = request.getParameter("encoded");
        String idInput = getParam(userRequest, "idinput");
        String mode = getParam(userRequest, "mode");
        if (mode.equals("delete")) {
            gs.deleteGroupById(Integer.parseInt(idInput));
            return "Your DELETE request has been accepted by the server.";
        }

        String description = getParam(userRequest, "description");

        if (mode.equals("create")) {

            Group group = new Group();
            List<String> specialNotes = new ArrayList<String>();
            specialNotes.add(description);
            group.setSpecialNotes(specialNotes);
            gs.createGroup(group);
            return "Your CREATE request has been accepted by the server: ";
        }

        if (mode.equals("update")) {
            Group group = new Group();

            group.setId(Integer.parseInt(idInput));
            List<String> specialNotes = new ArrayList<String>();
            specialNotes.add(description);
            group.setSpecialNotes(specialNotes);
            gs.updateGroup(Integer.parseInt(idInput), group);
            return "Your UPDATE request has been accepted by the server.";
        }

        return "The server has recieved an unsupported mode command: " + mode;
    }

}
