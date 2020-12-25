package com.danielsedoff.college.schedule.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.danielsedoff.college.schedule.config.TestWebConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestWebConfig.class)
@WebAppConfiguration
public abstract class DAOTest {
    final String SQL_FILE_NAME = "create_tables.sql";

}
