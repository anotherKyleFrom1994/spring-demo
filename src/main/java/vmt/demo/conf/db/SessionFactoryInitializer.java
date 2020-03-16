package vmt.demo.conf.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Initialize a sessionFactory that can be used in DAO layer.
 * 
 * @author Kyle Lin
 * @see
 */

public class SessionFactoryInitializer {

	/**
	 * To register a instance in Spring, an interface should be created and be
	 * implemented, in order to make the instances under control.
	 * 
	 * @author Kyle Lin
	 */
	public interface ISessionFactoryCreator {
	};

	/**
	 * {@code @Repository} notify Spring here's a repository that should be managed
	 * by the framework, and exposes itself to Spring.
	 * 
	 * @author Kyle Lin
	 * @see
	 */
	@Repository
	public static class SessionFactoryCreator implements ISessionFactoryCreator {
		@Autowired
		private SessionFactory sessionFactory;

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public Session getSession() throws Exception {
			try {
				if (sessionFactory.isClosed()) {
					sessionFactory.openSession();
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}

			return this.sessionFactory.getCurrentSession();
		}
	}

}
