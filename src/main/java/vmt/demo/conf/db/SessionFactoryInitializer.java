package vmt.demo.conf.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Make SessionFactory created in Singleton mode
 * 
 * @author Kyle Lin
 * @see
 */

public class SessionFactoryInitializer {

	public interface ISessionFactoryCreator {
		public Session getSession();
	};

	@Repository
	public static class SessionFactoryCreator implements ISessionFactoryCreator {
		@Autowired
		private SessionFactory sessionFactory;

		public SessionFactoryCreator() {
			super();
		}

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public Session getSession() {
			this.sessionFactory.openSession();
			return this.sessionFactory.getCurrentSession();
		}
	}

}
