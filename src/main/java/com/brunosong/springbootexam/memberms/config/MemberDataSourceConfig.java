package com.brunosong.springbootexam.memberms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MemberDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.memberms-datasource")
    public DataSource memberDatasource() {
        return DataSourceBuilder.create().build();
    }

}
