package com.demo.conf.db;

import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.conf.aop.AOPConfig;
import com.demo.conf.spring.WebConfigs;

/**
 * Here's the configuration class that bind with Hibernate and delegated to
 * Spring.
 * 
 * <p>
 * {@code @EnableTransactionManagement} Enables Spring's annotation-driven
 * transaction management capability, similar to the support found in Spring's
 * {@code <tx:*>}.
 * </p>
 * 
 * <p>
 * To obtain the attributes in *.properties files, Spring provides
 * {@code @PropertySource} and {@code @Enviroment}.
 * </p>
 * <p>
 * All you have to do is to provide properties' classpath, then you can get the
 * attributes. There are many ways to register JPA usage in annotation. I've
 * chose the easiest one I supposed.
 * </p>
 * <p>
 * The configuration style is as same as others.
 * </p>
 * 
 * @author Kyle Lin
 * @see AOPConfig
 * @see WebConfigs
 */
@Configuration
@PropertySource(value = { "classpath:jdbc.properties", "classpath:hibernate.properties" })
@ComponentScan(basePackages = { "com.demo.conf.db" })
@EnableTransactionManagement
public class DBConfigs {

	@Autowired
	private Environment env;

	/**
	 * {@code @Bean} is auto refers to the methods of bean, if there is {@code
	 * shutdown()} or {@code close()} method, will be auto referred. It can be also
	 * registered as {@code @Bean(destroyMethod = "shutdown")}, but usually it's not
	 * necessary.
	 * 
	 * @see <a href=
	 *      "https://www.ojit.com/article/1823563">https://www.ojit.com/article/1823563</a>
	 */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();

		props.put(DRIVER, env.getProperty("demo.db.driver"));
		props.put(URL, env.getProperty("demo.db.jdbcUrl"));
		props.put(USER, env.getProperty("demo.db.username"));
		props.put(PASS, env.getProperty("demo.db.password"));

		props.put(C3P0_MIN_SIZE, env.getProperty("demo.connectionPool.min_size"));
		props.put(C3P0_MAX_SIZE, env.getProperty("demo.connectionPool.max_size"));
		props.put(C3P0_TIMEOUT, env.getProperty("demo.connectionPool.timeout"));
		props.put(SHOW_SQL, true);
		props.put(FORMAT_SQL, true);

		factoryBean.setHibernateProperties(props);

		/* Legacy XML config usage */
		// factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));

		/* Scan Components by registering classes */
		// factoryBean.setAnnotatedClasses(UserEntity.class);

		/* Scan components by packages(recommend) */
		factoryBean.setPackagesToScan(env.getProperty("packages.to.scan"));

		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
