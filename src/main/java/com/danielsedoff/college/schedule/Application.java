package com.danielsedoff.college.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.danielsedoff.college.schedule.config.MainWebAppInitializer;
import com.danielsedoff.college.schedule.config.WebConfig;

@SpringBootApplication
@ComponentScan(basePackages = "com.danielsedoff.college.schedule")
@Import({ WebConfig.class, MainWebAppInitializer.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}