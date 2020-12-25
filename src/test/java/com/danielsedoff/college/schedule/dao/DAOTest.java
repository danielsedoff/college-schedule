package com.danielsedoff.college.schedule.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.danielsedoff.college.schedule.config.DataSourceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataSourceConfig.class)
public abstract class DAOTest {
    final String SQL_FILE_NAME = "create_tables.sql";

}
