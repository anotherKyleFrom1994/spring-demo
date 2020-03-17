package vmt.demo.conf.spring;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import vmt.demo.conf.aop.AOPConfig;
import vmt.demo.conf.db.DBConfigs;

/**
 * <p>
 * This is the core initializer that pushes the whole system start working. It's
 * the basis of Spring Framework. Without this class, the container will never
 * know that Spring is registered.
 * </p>
 * <p>
 * There are other ways to fulfill the same requirement. I've chosen the
 * simplest one that I supposed. If you're interested in other ways to configure
 * Spring Framework.
 * 
 * <pre>
 * Here's the official documentation: <a href=
 * "https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html">Spring Framework</a>
 * </pre>
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

	/**
	 * Here's the overriding method to register ServletContextListener in Spring.
	 * 
	 * @see org.springframework.web.context.AbstractContextLoaderInitializer#registerContextLoaderListener(javax.servlet.ServletContext)
	 */
	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		servletContext.addListener(ContextListener.class);
		super.registerContextLoaderListener(servletContext);
	}

	/**
	 * Servlet filters can be registered here
	 * 
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#registerServletFilter(javax.servlet.ServletContext,
	 *      javax.servlet.Filter)
	 */
	@Override
	protected Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
		return super.registerServletFilter(servletContext, filter);
	}

	/**
	 * This is the initial register overriding method to register the Servlet
	 * context. If you are using legacy XML configuration, here is also the place to
	 * get the necessary attributes.
	 * 
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#onStartup(javax.servlet.ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Read "applicationContext.xml" here when using legacy settings.
		super.onStartup(servletContext);
	}

	/**
	 * <p>
	 * Here's another way to register dispatcherServlet. Though it's more
	 * complicated to do so, it provides the native ServletContext, and provides
	 * more flexibility.
	 * </p>
	 * <p>
	 * Even so, I still prefer the way using {@code @Configuration} annotation to
	 * approach the same result. For Example: {@link WebConfigs}
	 * </p>
	 * 
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#registerDispatcherServlet(javax.servlet.ServletContext)
	 */
	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		super.registerDispatcherServlet(servletContext);
	}
}