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
        basePackages = "com.brunosong.springbootexam.repository.member",
        entityManagerFactoryRef = "memberEntityManager",
        transactionManagerRef = "memberJpaTransactionManager"
)
@Configuration
public class MemberDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.member-datasource")
    public DataSource memberDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean memberEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(memberDatasource());
        em.setPackagesToScan(new String[]{"com.brunosong.springbootexam.entity.member"});
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
    public PlatformTransactionManager memberJpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(memberEntityManager().getObject());
        return transactionManager;
    }

}
