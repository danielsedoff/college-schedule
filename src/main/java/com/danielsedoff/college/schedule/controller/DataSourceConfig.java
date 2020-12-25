package com.danielsedoff.college.schedule.controller;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix="application.properties")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
        dataSourceBuilder.username("postgres"); 
        dataSourceBuilder.password("mallocError"); 
        return dataSourceBuilder.build(); 
    }
}
