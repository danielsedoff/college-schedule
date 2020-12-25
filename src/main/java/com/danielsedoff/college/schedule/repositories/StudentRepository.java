package com.danielsedoff.college.schedule.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielsedoff.college.schedule.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
