package com.danielsedoff.college.schedule.dao;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractDAOTest {
    public static final String SQL_FILE_NAME = "create_tables.sql";

    AbstractDAOTest() {

    }
}
