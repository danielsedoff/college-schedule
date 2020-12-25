package com.danielsedoff.college.schedule.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlScriptRunner {

    @Autowired
    DataSource dataSource;

    public void readSQLFileWithIbatis(String fileName) throws IOException, SQLException {
        ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        runner.setLogWriter(null);
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        runner.runScript(new FileReader(file));
        runner.closeConnection();
    }
}
