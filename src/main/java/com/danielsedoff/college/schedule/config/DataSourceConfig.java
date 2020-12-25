package com.danielsedoff.college.schedule.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DataSourceConfig {
    @Bean 
    public DataSource getDataSource() { 
        @SuppressWarnings("rawtypes")
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
        dataSourceBuilder.username("postgres"); 
        dataSourceBuilder.password("mallocError"); 
        return dataSourceBuilder.build(); 
    }
}
