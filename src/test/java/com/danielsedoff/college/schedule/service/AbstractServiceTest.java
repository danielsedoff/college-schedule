package com.danielsedoff.college.schedule.service;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.dao.SqlScriptRunner;

@SpringBootTest
public class AbstractServiceTest {

    public static final String SQL_FILE_NAME = "create_tables.sql";

    AbstractServiceTest() {

    }

    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }
}
