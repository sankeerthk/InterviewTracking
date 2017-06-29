package com.bofa.interview.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:datasource-cfg.properties" })
@ComponentScan({ "com.bofa.interview.persistence" })
public class PersistenceConfig {

	@Autowired
	private Environment env;

	/**
	 * Configure the local session factory bean.
	 * 
	 * @return LocalSessionFactoryBean the local session factory bean
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.bofa.interview.persistence.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	/**
	 * Configure the data source bean to be used by session factory
	 * 
	 * @return DataSource the data source for database
	 */
	@Bean(destroyMethod="")
	public DataSource  dataSource() {
		 BasicDataSource dataSource = new BasicDataSource();
		    dataSource.setDriverClassName(env.getProperty("dataSource.jdbc.driver"));
		    dataSource.setUrl(env.getProperty("dataSource.jdbc.url"));
		    dataSource.setUsername(env.getProperty("dataSource.jdbc.usereName"));
		    dataSource.setPassword(env.getProperty("dataSource.jdbc.password"));
		  return dataSource;
	}

	/**
	 * Configure the Hibernate transaction manager.
	 * 
	 * @param sessionFactory
	 *            the session factory attribute
	 * 
	 * @return HibernateTransactionManager the Hibernate transaction manager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	/**
	 * Configure the bean post processor that automatically applies persistence
	 * exception translation to repository beans
	 * 
	 * @return the post-processor bean
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Configure the Hiibernate properties.
	 * 
	 * @return the Hashtable of Hibernate properties
	 */
	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
			{
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
				setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
				setProperty("hibernate.jdbc.use_streams_for_binary", env.getProperty("hibernate.jdbc.use_streams_for_binary"));
				setProperty("hibernate.cglib.use_reflection_optimizer", env.getProperty("hibernate.cglib.use_reflection_optimizer"));
			}
		};
	}
}