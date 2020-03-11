package vmt.demo.conf.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import vmt.demo.conf.db.DBConfigs;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { DBConfigs.class };
	}

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