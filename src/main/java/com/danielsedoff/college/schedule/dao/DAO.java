package com.danielsedoff.college.schedule.dao;

import java.util.List;

public interface DAO<T> {
    T getById(Integer id) throws DAOException;

    List<Integer> getIdList() throws DAOException;

    boolean delete(T item) throws DAOException;

    boolean update(Integer id, T item) throws DAOException;

    boolean create(T item) throws DAOException;

    List<T> getList() throws DAOException;
}
