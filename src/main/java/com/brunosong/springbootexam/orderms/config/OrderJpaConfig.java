package com.brunosong.springbootexam.orderms.config;

import com.brunosong.springbootexam.orderms.config.OrderMsJpaProperties;
import org.springframework.beans.factory.annotation.Qualifier;
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

@EnableJpaRepositories(
        basePackages = {"com.brunosong.springbootexam.orderms.repository","com.brunosong.springbootexam.codems.repository"},
        entityManagerFactoryRef = "orderEntityManager",
        transactionManagerRef = "orderJpaTransactionManager"
)
@Configuration
public class OrderJpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean orderEntityManager(
                                                                    @Qualifier("orderDatasource") DataSource orderDataSource,
                                                                    OrderMsJpaProperties orderMsJpaProperties,
                                                                    @Qualifier("orderMsJpaVendorAdapter") JpaVendorAdapter orderMsJpaVendorAdapter ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(orderDataSource);
        em.setPackagesToScan(new String[]{"com.brunosong.springbootexam.orderms.repository", "com.brunosong.springbootexam.codems.repository"});
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
