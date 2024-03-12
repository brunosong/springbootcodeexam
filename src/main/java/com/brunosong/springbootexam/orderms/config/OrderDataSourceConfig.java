package com.brunosong.springbootexam.orderms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class OrderDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.orderms-datasource")
    public DataSource orderDatasource() {
        return DataSourceBuilder.create().build();
    }

}
