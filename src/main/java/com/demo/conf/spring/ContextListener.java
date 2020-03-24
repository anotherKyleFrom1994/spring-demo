package com.demo.conf.spring;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <p>
 * This class implements native Servlet listener. In order to make it easier to
 * get native attributes, which can be manipulated here to process some tasks.
 * </p>
 * <p>
 * e.g. You can deregister the Drivers here, or doing something before server
 * start-up and shut down.
 * </p>
 * 
 * @author Kyle Lin
 */
public class ContextListener implements ServletContextListener {

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Do somthing before server shutting down");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Do somthing on server start-up");
	}

}
