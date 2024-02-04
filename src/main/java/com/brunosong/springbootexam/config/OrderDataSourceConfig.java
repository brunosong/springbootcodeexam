package com.brunosong.springbootexam.config;

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
        basePackages = "com.brunosong.springbootexam.repository.order",
        entityManagerFactoryRef = "orderEntityManager",
        transactionManagerRef = "orderJpaTransactionManager"
)
@Configuration
public class OrderDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.order-datasource")
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
        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.hbm2ddl.auto", "create-drop");
        prop.put("hibernate.format_sql", true);
        prop.put("hibernate.show_sql", "true");
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
