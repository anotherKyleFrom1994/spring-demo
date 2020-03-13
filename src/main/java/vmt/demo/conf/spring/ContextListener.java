package vmt.demo.conf.spring;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * You can deregister the Drivers here, or doing something before server
 * start-up and shut down.
 * 
 * @author Kyle Lin
 * @see
 */
@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Do somthing before server shutting down");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Do somthing on server start-up");
	}

}
