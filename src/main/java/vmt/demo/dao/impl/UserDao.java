package vmt.demo.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import vmt.demo.conf.db.SessionFactoryInitializer.SessionFactoryCreator;
import vmt.demo.dao.IUserDao;
import vmt.demo.model.entity.UserEntity;

/**
 * This DAO class extends custom class to get the session factory instance.
 * 
 * @author KyleLin
 */
@Repository
public class UserDao extends SessionFactoryCreator implements IUserDao {
	private Session session = null;

	public UserDao() {
		super();
	}

	/**
	 * Transaction is managed by Spring. Basically in here, we only have to annotate
	 * {@code @Transactional} as it use <em>Intercepter</em> to begin transaction
	 * before method started, and at the end of execution.
	 * 
	 * @see vmt.demo.dao.IUserDao#addUser(java.lang.String, java.lang.String)
	 */
	@Transactional(readOnly = true, transactionManager = "")
	@Override
	public UserEntity addUser(String username, String password) {
		UserEntity user = null;

		// if (username == null || password == null) {
		// throw new NullPointerException("Parameters point at null value");
		// }

		try {
			session = this.getSession();

			user = new UserEntity();
			user.setUserName(username);
			user.setPassword(password);

			session.persist(user);
			session.flush();

		} catch (Exception e) {
			throw new RuntimeException(this.getClass().getName() + " --> " + e.getMessage());

		} finally {
			if (session != null) {
				session.flush();
			}
		}

		return user;
	}

//	@Autowired
//	private DataSourceTransactionManager transactionManager;
	@Transactional(readOnly = true)
	@Override
	public UserEntity updateUser(UserEntity user) {
//		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		
//		TransactionStatus status = transactionManager.getTransaction(def);
		if (user == null) {
			throw new NullPointerException("UserEntity point at null value");
		}

		try {
			session = this.getSession();
			session.update(user);
			session.flush();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}

			throw new RuntimeException(this.getClass().getName() + " --> " + e.getMessage());
		}

		return user;
	}
}