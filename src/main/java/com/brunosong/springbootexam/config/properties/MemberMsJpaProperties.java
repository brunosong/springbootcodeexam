package com.brunosong.springbootexam.config.properties;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "spring.memberms-jpa"
)
public class MemberMsJpaProperties extends JpaProperties {

}
