package webdemo.mvcspring.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import webdemo.mvcspring.model.*;


@Configuration
@EnableTransactionManagement
@ComponentScan({"webdemo.mvcspring"})
@PropertySource({ "classpath:mysql.properties" })
public class HibernateConfig {

	   @Autowired
	   private Environment env;

	   @Bean
	   public AnnotationSessionFactoryBean sessionFactory() {
	      AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
	      sessionFactory.setDataSource(restDataSource());
	      sessionFactory.setPackagesToScan(new String[] { "webdemo.mvcspring.model" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	      Class[] annotatedClasses= new Class[] {User.class};
		  sessionFactory.setAnnotatedClasses(annotatedClasses);
	      return sessionFactory;
	   }

	   @Bean
	   public DataSource restDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	      dataSource.setUrl(env.getProperty("jdbc.url"));
	      dataSource.setUsername(env.getProperty("jdbc.user"));
	      dataSource.setPassword(env.getProperty("jdbc.pass"));
	      return dataSource;
	   }

	   @Bean
	   @Autowired
	   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	      HibernateTransactionManager txManager = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);

	      return txManager;
	   }

	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }

	   Properties hibernateProperties() {
	      return new Properties() {
	         {
	            setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	            setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	            setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	         }
	      };
	   }
	
	
}
