package com.example.springbootdata4jpaext;


import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:persistence-multiple-db-boot.properties"})
@EnableJpaRepositories( entityManagerFactoryRef= "secondEntityManager", transactionManagerRef = "secondTransactionManager", basePackages =  "com.example.springbootdata4jpaext.repo_second" )
public class ExtendedDBConfig {
    
    @Autowired
    private Environment env;

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix="spring.second-datasource")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().build();
    }


    // @Primary
    // @Bean(name = "bookingEntityManager")
    // public LocalContainerEntityManagerFactoryBean entityManagerFactory( EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
    //     return builder.dataSource( dataSource).packages("com.example.springbootdata4jpaext.model").persistenceUnit("defaultDB_PU").build();
    // }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondDataSource());
        em.setPackagesToScan("com.example.springbootdata4jpaext.model_second");
        em.setPersistenceUnitName("secondDB_PU");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }    

    @Bean
    public PlatformTransactionManager secondTransactionManager() {
        
        final JpaTransactionManager secondTransactionManager = new JpaTransactionManager();
        secondTransactionManager.setEntityManagerFactory( secondEntityManager().getObject());
        return secondTransactionManager;
    }

}