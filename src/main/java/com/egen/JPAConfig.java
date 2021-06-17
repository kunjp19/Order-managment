package com.egen;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:/resources/application.properties")
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		//TODO: configure emf
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(emf().getDataSource());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.egen.model");

		Properties properties = jpaProperties();
		emf.setJpaProperties(properties);
		return emf;

	}

	@Bean
	public DataSource dataSource() {
		//TODO: configure data source bean
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("db.url");
		ds.setUsername("db.user");
		ds.setPassword("db.password");
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		//TODO: configure transaction manager
		JpaTransactionManager jtm = new JpaTransactionManager((emf));
		return jtm;
	}


	@Bean
	Properties jpaProperties() {
		//TODO: configure jpa properties
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		// we can add other methods while testing like creat,update,create_drop
		properties.put("hibernate.hbm2ddl.auto", "validate");
		// this will show that what queries perform by hibernate JPA
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
}
