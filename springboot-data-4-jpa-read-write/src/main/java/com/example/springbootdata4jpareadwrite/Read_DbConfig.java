package com.example.springbootdata4jpareadwrite;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "readDSEmFactory",
    transactionManagerRef = "readDSTransactionManager", basePackages = {"com.example.springbootdata4jpareadwrite.repo_read"})
public class Read_DbConfig {

 
  //Untuk SpringBoot Versi 1.x.x
  // @Bean(name = "barDataSource")
  // @ConfigurationProperties(prefix = "bar.datasource")
  // public DataSource dataSource() {
  //   return DataSourceBuilder.create().build();
  // }

  @Bean
	@ConfigurationProperties("read-only.datasource")
	public DataSourceProperties readDSProperties() {
		return new DataSourceProperties();
  }
  @Bean
	public DataSource readDS(@Qualifier("readDSProperties") DataSourceProperties readDSProperties) {
		return readDSProperties.initializeDataSourceBuilder().build();
  }  
  

  //Untuk SpringBoot Versi 1.x.x
  // @Bean(name = "barEntityManagerFactory")
  // public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
  //     EntityManagerFactoryBuilder builder, @Qualifier("barDataSource") DataSource dataSource) {
  //   return builder.dataSource(dataSource).packages("com.example.springbootdata4jpaext.bar.domain").persistenceUnit("bar")
  //       .build();
  // }
  @Bean
	public LocalContainerEntityManagerFactoryBean readDSEmFactory(@Qualifier("readDS") DataSource readDS, EntityManagerFactoryBuilder builder) {
		// return builder.dataSource(readDS).packages(Bar.class).build();
    return builder.dataSource(readDS).packages("com.example.springbootdata4jpareadwrite.model").persistenceUnit("bar_PU").build();
    
  }
  

  //Untuk SpringBoot Versi 1.x.x
  // @Bean(name = "barTransactionManager")
  // public PlatformTransactionManager barTransactionManager(
  //     @Qualifier("barEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
  //   return new JpaTransactionManager(barEntityManagerFactory);
  // }
	@Bean
	public PlatformTransactionManager readDSTransactionManager(EntityManagerFactory readDSEmFactory) {
		return new JpaTransactionManager(readDSEmFactory);
  }
  

}
