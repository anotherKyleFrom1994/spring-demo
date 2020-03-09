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

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}