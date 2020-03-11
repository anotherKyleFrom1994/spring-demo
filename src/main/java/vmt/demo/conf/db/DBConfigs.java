package vmt.demo.conf.db;

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
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties", "classpath:hibernate.properties" })
@EnableTransactionManagement
// @ComponentScans(value = { @ComponentScan("vmt.demo") })
public class DBConfigs {
	@Autowired
	private Environment env;
	// @Autowired
	// private ApplicationContext context;

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

		// * Legacy XML config usage
		// factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));

		// * Scan Components by register classes
		// factoryBean.setAnnotatedClasses(UserEntity.class);

		// * Scan components by packages(recommend)
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
