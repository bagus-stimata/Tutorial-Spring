package com.example.springbootdata4jpaext;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@EnableJpaRepositories(entityManagerFactoryRef = "barDSEmFactory",
    transactionManagerRef = "barDSTransactionManager", basePackages = {"com.example.springbootdata4jpaext.bar.repo"})
public class BarDbConfig {

 
  //Untuk SpringBoot Versi 1.x.x
  // @Bean(name = "barDataSource")
  // @ConfigurationProperties(prefix = "bar.datasource")
  // public DataSource dataSource() {
  //   return DataSourceBuilder.create().build();
  // }

  @Bean
	@ConfigurationProperties("bar.datasource")
	public DataSourceProperties barDSProperties() {
		return new DataSourceProperties();
  }
  @Bean
	public DataSource barDS(@Qualifier("barDSProperties") DataSourceProperties barDSProperties) {
		return barDSProperties.initializeDataSourceBuilder().build();
  }  
  

  //Untuk SpringBoot Versi 1.x.x
  // @Bean(name = "barEntityManagerFactory")
  // public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
  //     EntityManagerFactoryBuilder builder, @Qualifier("barDataSource") DataSource dataSource) {
  //   return builder.dataSource(dataSource).packages("com.example.springbootdata4jpaext.bar.domain").persistenceUnit("bar")
  //       .build();
  // }
  @Bean
	public LocalContainerEntityManagerFactoryBean barDSEmFactory(@Qualifier("barDS") DataSource barDS, EntityManagerFactoryBuilder builder) {
		// return builder.dataSource(barDS).packages(Bar.class).build();
    return builder.dataSource(barDS).packages("com.example.springbootdata4jpaext.bar.domain").persistenceUnit("bar_PU").build();
    
  }
  

  //Untuk SpringBoot Versi 1.x.x
  // @Bean(name = "barTransactionManager")
  // public PlatformTransactionManager barTransactionManager(
  //     @Qualifier("barEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
  //   return new JpaTransactionManager(barEntityManagerFactory);
  // }
	@Bean
	public PlatformTransactionManager barDSTransactionManager(EntityManagerFactory barDSEmFactory) {
		return new JpaTransactionManager(barDSEmFactory);
  }
  

}
