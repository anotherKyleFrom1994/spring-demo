package vmt.demo.common;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { DBConfigs.class };
//		return new Class[] {};
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