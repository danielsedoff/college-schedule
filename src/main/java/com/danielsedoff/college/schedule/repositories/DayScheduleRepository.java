package com.danielsedoff.college.schedule.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielsedoff.college.schedule.model.DaySchedule;
@Repository
public interface DayScheduleRepository extends CrudRepository<DaySchedule, Integer> {
}
