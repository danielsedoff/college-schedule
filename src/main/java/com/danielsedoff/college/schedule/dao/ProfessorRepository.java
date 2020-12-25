package com.danielsedoff.college.schedule.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielsedoff.college.schedule.model.Professor;
@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
}
