package com.ksm.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
@PropertySource("/properties/jdbc.properties")
public class DbConfig {

	private @Value("${jdbc.driverClassName}") String jdbcDriver;
	private @Value("${jdbc.dialect}") String jdbcDialect;
	private @Value("${jdbc.databaseurl}")String jdbcDatabaseUrl;
	private @Value("${jdbc.username}") String jdbcUsername;
	private @Value("${jdbc.password}") String jdbcPassword;

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(
				dataSource());
		builder.scanPackages("com.ksm.users.model" +
				"", "com.ksm.person" +
				"").addProperties(
				getHibernateProperties());

		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		// prop.put("hibernate.dialect", jdbcDialect);
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return prop;
	}

	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(jdbcDriver);
		ds.setUrl(jdbcDatabaseUrl);
		ds.setUsername(jdbcUsername);
		ds.setPassword(jdbcPassword);
		return ds;

		// BasicDataSource ds = new BasicDataSource();
		// ds.setDriverClassName("com.mysql.jdbc.Driver");
		// ds.setUrl("jdbc:mysql://localhost:3306/test");
		// ds.setUsername("root");
		// ds.setPassword("kameron");
		// return ds;
	}

	@Bean
	public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

}
