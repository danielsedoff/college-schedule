package com.danielsedoff.college.schedule.model.validation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LessonDateValidator implements ConstraintValidator<LessonDateConstraint, String> {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void initialize(LessonDateConstraint lessonDate) {
    }

    @Override
    public boolean isValid(String lessonDate, ConstraintValidatorContext cxt) {
        try {
            LocalDateTime date = LocalDateTime.parse(lessonDate, formatter);
            return (null != date);
        } catch (Exception e) {
            return false;
        }
    }

}