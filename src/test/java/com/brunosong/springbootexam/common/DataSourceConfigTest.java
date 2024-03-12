package com.brunosong.springbootexam.common;

import com.zaxxer.hikari.HikariDataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootTest
class DataSourceConfigTest {

    @Autowired
    Environment env;

    @Autowired
    @Qualifier("memberDatasource")
    DataSource memberDatasource;


    @Autowired
    @Qualifier("orderDatasource")
    HikariDataSource orderDatasource;    //추천하지 않는다고 인텔리제이가 알려주지만 작동은 가능하다.


    @Test
    @DisplayName("h2가 2대가 연결이 되었는지 확인한다.")
    void h2MultiDatasourceConfigCheck() {

        HikariDataSource hikariMemberDataSource = (HikariDataSource) memberDatasource;
        Assertions.assertThat(hikariMemberDataSource.getJdbcUrl()).isEqualTo(env.getProperty("spring.memberms-datasource.jdbc-url"));

        Assertions.assertThat(orderDatasource.getJdbcUrl()).isEqualTo(env.getProperty("spring.orderms-datasource.jdbc-url"));

    }

}