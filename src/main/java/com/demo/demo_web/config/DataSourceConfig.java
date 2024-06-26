package com.demo.demo_web.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
