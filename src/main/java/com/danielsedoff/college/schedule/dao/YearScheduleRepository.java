package com.danielsedoff.college.schedule.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielsedoff.college.schedule.model.YearSchedule;
@Repository
public interface YearScheduleRepository extends CrudRepository<YearSchedule, Integer> {
}
