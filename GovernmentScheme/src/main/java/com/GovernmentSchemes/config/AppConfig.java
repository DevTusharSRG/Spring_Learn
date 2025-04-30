package com.GovernmentSchemes.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.GovernmentSchemes.GovernmentSchemeReport")
@ComponentScan(basePackages = "com.GovernmentSchemes.user")
//@ComponentScan(basePackages = "com.GovernmentSchemes.GovernmentSchemes")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/colabDB");
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		return ds;
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        
        // Ensure both model packages are scanned
        //factoryBean.setPackagesToScan("com.GovernmentSchemes.GovernmentSchemeReport.model");
        factoryBean.setPackagesToScan("com.GovernmentSchemes.user.model");
        //factoryBean.setPackagesToScan("com.GovernmentSchemes.GovernmentSchemes.model");
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");  // Can be changed to 'validate' or 'create' based on needs
        props.put("hibernate.show_sql", "true");  // Enables SQL logging
        return props;
    }
}