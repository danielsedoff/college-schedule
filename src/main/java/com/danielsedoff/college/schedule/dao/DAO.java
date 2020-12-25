package com.danielsedoff.college.schedule.dao;

import java.util.List;

public interface DAO<T> {
    T getById(Integer id);

    List<Integer> getIdList();

    boolean delete(T item);

    boolean update(Integer id, T item);

    boolean create(T item);
}
