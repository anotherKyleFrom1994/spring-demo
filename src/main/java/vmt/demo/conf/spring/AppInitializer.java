package vmt.demo.conf.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import vmt.demo.conf.aop.AOPConfig;
import vmt.demo.conf.db.DBConfigs;

/**
 * <p>
 * This is the core initializer that pushes the whole system start working. It's
 * the basis of Spring Framework. Without this class, the container will never
 * know that Spring is registered.
 * </p>
 * 
 * <p>
 * There are other ways to fulfill the same requirement. I've chosen the
 * simplest one that I supposed. If you're interested in other ways to configure
 * Spring Framework, here's the official documentation: <a href=
 * "https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html">Spring
 * Framework</a>
 * </p>
 * 
 * @author Kyle Lin
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Basic persistence configurations and functional setting.
	 * 
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { DBConfigs.class, AOPConfig.class };
	}

	/**
	 * Basic web servlet settings are included.
	 * 
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfigs.class };
	}

	/**
	 * Specify the suffix naming of the request URL pattern (e.g.
	 * http://localhost:8080/create.do )
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/", "*.do" };
	}
}