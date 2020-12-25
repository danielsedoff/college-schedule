package com.danielsedoff.college.schedule.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.dao.SqlScriptRunner;

public abstract class ControllerTest {
    final String SQL_FILE_NAME = "create_tables.sql";

    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    void runIbatis() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

}
