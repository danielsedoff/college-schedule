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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.danielsedoff.college.schedule.dto.StudentDTO;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.StudentService;

@Controller
public class StudentWebController implements WebMvcConfigurer {

    @Autowired
    StudentService ss;

    @Autowired
    GroupService gs;

    @GetMapping("/studentList")
    public String getStudents(Model model) {
        List<Student> students = ss.getStudentList();
        if (null == students) {
            model.addAttribute("result", "ERROR: the expected LIST is NULL.");
            return "resultPage";
        }
        model.addAttribute("students", students);
        model.addAttribute("testvalue", "passed");
        return "studentList";
    }

    @RequestMapping(value = "/studentForm", params = { "id" }, method = RequestMethod.GET)
    public String getIdParam(@RequestParam("id") int id, @ModelAttribute("studentdto") StudentDTO studentdto,
            Model model) {
        if (id == -1) {
            studentdto.setMode("create");
            return "studentForm";
        }
        Student student = ss.getStudentById(id);
        studentdto.setId(id);
        studentdto.setMode("update");
        studentdto.setGroupId(student.getGroup().getId());
        studentdto.setName(student.getName());
        studentdto.setSchoolYear(student.getSchoolYear());
        model.addAttribute("testvalue", "passed");
        return "studentForm";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@ModelAttribute("studentdto") StudentDTO studentdto, Model model) {
        ss.deleteStudentById(studentdto.getId());
        model.addAttribute("result", "Your DELETE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/createStudent")
    public String createStudent(@ModelAttribute("studentdto") StudentDTO studentdto, Model model) {
        Student student = new Student();
        student.setGroup(gs.getGroupById(studentdto.getGroupId()));
        student.setName(studentdto.getName());
        student.setSchoolYear(studentdto.getSchoolYear());
        ss.createStudent(student);
        model.addAttribute("result", "Your CREATE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("studentdto") StudentDTO studentdto, Model model) {
        Student student = new Student();
        student.setGroup(gs.getGroupById(studentdto.getGroupId()));
        student.setName(studentdto.getName());
        student.setSchoolYear(studentdto.getSchoolYear());
        ss.updateStudent(studentdto.getId(), student);
        model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
        return "resultPage";
    }

}
