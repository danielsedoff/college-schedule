package com.danielsedoff.college.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ResponseBodyController {

    @GetMapping("/notemplate")
    public String notemplate() {
        return "<!doctype html><html><head></head><body><h1>Status Pages</h1>"
                + "<DIV STYLE=\"font-size:24px;\">"
                + "<ul>"
                + "<li>Generate text without templates</li>"
                + "<li>Do whatever you want</li>"
                + "<li>Use the ResponseBody tag</li>"
                + ""
                + "</ul>"
                + "</body></html>";
    }
}
