package com.danielsedoff.college.schedule.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielsedoff.college.schedule.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
