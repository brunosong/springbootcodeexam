package com.brunosong.springbootexam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@EnableJpaRepositories(
        basePackages = "com.brunosong.springbootexam.repository.orderms",
        entityManagerFactoryRef = "orderEntityManager",
        transactionManagerRef = "orderJpaTransactionManager"
)
@Configuration
public class OrderDataSourceConfig {

    @Value("${spring.orderms-jpa.database-platform}")
    private String dialect;

    @Value("${spring.orderms-jpa.properties.hibernate.format_sql}")
    private boolean isFormatSql;

    @Value("${spring.orderms-jpa.show_sql}")
    private boolean isShowSql;

    @Bean
    @ConfigurationProperties(prefix = "spring.orderms-datasource")
    public DataSource orderDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean orderEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(orderDatasource());
        em.setPackagesToScan(new String[]{"com.brunosong.springbootexam.entity.order"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> prop = new HashMap<>();
        prop.put("hibernate.dialect", dialect);
        prop.put("hibernate.format_sql", isFormatSql);
        prop.put("hibernate.show_sql", isShowSql);

        /* 이 부분은 예제로 사용을 해야 하기 때문에 넣어뒀다. 실제 환경에서는 쓰면 안된다. */
        prop.put("hibernate.hbm2ddl.auto", "create-drop");

        em.setJpaPropertyMap(prop);

        return em;
    }

    @Bean
    public PlatformTransactionManager orderJpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(orderEntityManager().getObject());
        return transactionManager;
    }

}
