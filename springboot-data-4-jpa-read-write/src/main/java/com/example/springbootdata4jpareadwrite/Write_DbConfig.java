package com.example.springbootdata4jpareadwrite;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "writeDSEmFactory",  transactionManagerRef = "writeDSTransactionManager", 
    basePackages = {"com.example.springbootdata4jpareadwrite.repo_write"})
public class Write_DbConfig {

  @Autowired
  private Environment env;
    
  //Untuk SpringBoot Versi 1.x.x
  // @Primary
  // @Bean(name = "dataSource")
  // @ConfigurationProperties(prefix = "spring.datasource")
  // public DataSource dataSource() {
  //   return DataSourceBuilder.create().build();
  // }

	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties writeDSProperties() {
    // DataSourceProperties dsProperties = new DataSourceProperties();
    
		return new DataSourceProperties();
  } 
  @Primary
	@Bean
	public DataSource writeDS(@Qualifier("writeDSProperties") DataSourceProperties writeDSProperties) {
		return writeDSProperties.initializeDataSourceBuilder().build();
	}  

  //Untuk SpringBoot Versi 1.x.x
  // @Primary
  // @Bean(name = "entityManagerFactory")
  // public LocalContainerEntityManagerFactoryBean entityManagerFactory(
  //     EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
  //   return builder.dataSource(dataSource).packages("com.example.springbootdata4jpaext.foo.domain").persistenceUnit("foo")
  //       .build();
  // }

  // @Primary
  // // @Bean(name = "writeDSEmFactory") //kalau nama methodnya tidak sama dengan nama @Bean
  // @Bean
	// public LocalContainerEntityManagerFactoryBean writeDSEmFactory(@Qualifier("writeDS") DataSource writeDS, EntityManagerFactoryBuilder builder) {
  //   // return builder.dataSource(writeDS).packages(Foo.class).build();
	// 	return builder.dataSource(writeDS).packages("com.example.springbootdata4jpareadwrite.model").persistenceUnit("foo_PU").build();
	// }  

  @Primary
  // @Bean(name = "writeDSEmFactory") //kalau nama methodnya tidak sama dengan nama @Bean
  @Bean
	public LocalContainerEntityManagerFactoryBean writeDSEmFactory(@Qualifier("writeDS") DataSource writeDS, EntityManagerFactoryBuilder builder) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource( writeDS );
    em.setPackagesToScan( new String[] { "com.example.springbootdata4jpareadwrite.model" });    
    em.setPersistenceUnitName("write_PU");
    
    HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));    
    em.setJpaPropertyMap(properties);

    // return builder.dataSource(writeDS).packages(Foo.class).build();
		// return builder.dataSource(writeDS).packages("com.example.springbootdata4jpareadwrite.model").persistenceUnit("foo_PU").build();
		return em;
	}  

  //Untuk SpringBoot Versi 1.x.x
  // @Primary
  // @Bean(name = "transactionManager")
  // public PlatformTransactionManager transactionManager(
  //     @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
  //   return new JpaTransactionManager(entityManagerFactory);
  // }
  //Nama writeDSEmFactory harus sama dengan diatas semua
  @Primary
	// @Bean("writeDSTransactionManager")
	@Bean
	public PlatformTransactionManager writeDSTransactionManager(EntityManagerFactory writeDSEmFactory) {
		return new JpaTransactionManager(writeDSEmFactory);
	}

}
