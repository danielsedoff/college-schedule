package com.danielsedoff.college.schedule.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.repositories.SqlScriptRunner;

public abstract class ControllerTest {
    public static final String SQL_FILE_NAME = "create_tables.sql";

    @Autowired
    protected SqlScriptRunner ibatisRead;

    @Order(1)
    void runIbatis() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }
}
