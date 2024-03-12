package com.brunosong.springbootexam.config;

import com.brunosong.springbootexam.config.properties.MemberMsJpaProperties;
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
        basePackages = "com.brunosong.springbootexam.repository.memberms",
        entityManagerFactoryRef = "memberEntityManager",
        transactionManagerRef = "memberJpaTransactionManager"
)
@Configuration
public class MemberJpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean memberEntityManager(
                                                                       @Qualifier("memberDatasource") DataSource memberDatasource,
                                                                       MemberMsJpaProperties memberMsJpaProperties,
                                                                       @Qualifier("memberMsJpaVendorAdapter") JpaVendorAdapter memberMsJpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(memberDatasource);
        em.setPackagesToScan(new String[]{"com.brunosong.springbootexam.entity.member"});
        em.setJpaVendorAdapter(memberMsJpaVendorAdapter);
        em.setJpaPropertyMap(memberMsJpaProperties.getProperties());

        return em;
    }

    @Bean
    public JpaVendorAdapter memberMsJpaVendorAdapter(MemberMsJpaProperties jpaProperties) {
        AbstractJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(jpaProperties.isShowSql());
        jpaVendorAdapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
        jpaVendorAdapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager memberJpaTransactionManager(@Qualifier("memberEntityManager") LocalContainerEntityManagerFactoryBean memberEntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(memberEntityManager.getObject());
        return transactionManager;
    }

}
