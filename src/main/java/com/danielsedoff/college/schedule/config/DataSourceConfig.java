package com.danielsedoff.college.schedule.config;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DataSourceConfig {

    @Bean
    public DataSource dataSource() throws NamingException, SQLException {

//        Context ctx = new InitialContext();
//        Properties props = (Properties) ctx.lookup("jdbc/datasource");
//        PGSimpleDataSource ds = new PGSimpleDataSource() ;  
//        ds.setServerName( props.getProperty("url") );  
//        ds.setDatabaseName( props.getProperty("dbname") );   
//        ds.setUser( props.getProperty("dbuser") );       
//        ds.setPassword( props.getProperty("dbpassword") );   
        
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/UsersDB");
        return ds;
    }
}
