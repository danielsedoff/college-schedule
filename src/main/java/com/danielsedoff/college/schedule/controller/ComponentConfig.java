package com.danielsedoff.college.schedule.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.danielsedoff.college.schedule.controller" })
public class ComponentConfig {
    //
}