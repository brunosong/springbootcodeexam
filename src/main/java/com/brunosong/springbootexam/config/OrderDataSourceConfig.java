package com.brunosong.springbootexam.config;

import com.brunosong.springbootexam.config.properties.MemberMsJpaProperties;
import com.brunosong.springbootexam.config.properties.OrderMsJpaProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
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

    @Bean
    @ConfigurationProperties(prefix = "spring.orderms-datasource")
    public DataSource orderDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean orderEntityManager(
                                    OrderMsJpaProperties orderMsJpaProperties,
                                    @Qualifier("orderMsJpaVendorAdapter") JpaVendorAdapter orderMsJpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(orderDatasource());
        em.setPackagesToScan(new String[]{"com.brunosong.springbootexam.entity.order"});
        em.setJpaVendorAdapter(orderMsJpaVendorAdapter);
        em.setJpaPropertyMap(orderMsJpaProperties.getProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager orderJpaTransactionManager(
                   @Qualifier("orderEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return transactionManager;
    }

    @Bean
    public JpaVendorAdapter orderMsJpaVendorAdapter(OrderMsJpaProperties jpaProperties) {
        AbstractJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(jpaProperties.isShowSql());
        jpaVendorAdapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
        jpaVendorAdapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        return jpaVendorAdapter;
    }

}
