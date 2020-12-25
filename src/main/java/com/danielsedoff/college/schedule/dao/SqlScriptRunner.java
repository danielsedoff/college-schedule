package com.danielsedoff.college.schedule.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class SqlScriptRunner {

    @Autowired
    DataSource dataSource;
    
    private static Logger logger = LoggerFactory.getLogger(SqlScriptRunner.class);
    
    @Bean
    public void readSQLFileWithIbatis(String fileName) throws IOException, SQLException {
        ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
    	File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        runner.runScript(new FileReader(file));
        runner.closeConnection();
    }
}
