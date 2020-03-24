package com.demo.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.conf.db.SessionFactoryInitializer.SessionFactoryCreator;
import com.demo.dao.IUserDao;
import com.demo.model.entity.UserEntity;

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
	 * @see com.demo.dao.IUserDao#addUser(java.lang.String, java.lang.String)
	 */
	@Transactional(readOnly = true)
	@Override
	public UserEntity addUser(String username, String password) {
		UserEntity user = null;

		if (username == null || password == null) {
			throw new NullPointerException("Parameters point at null value");
		}

		try {
			session = this.getSession();

			user = new UserEntity();
			user.setUserName(username);
			user.setPassword(password);

			session.persist(user);
			session.flush();

		} catch (Exception e) {
			throw new RuntimeException(this.getClass().getName() + " --> " + e.getMessage());

		}

		return user;
	}

	@Transactional(readOnly = true, rollbackFor = { Exception.class })
	@Override
	public UserEntity updateUser(UserEntity user) {

		if (user == null) {
			throw new NullPointerException("UserEntity point at null value");
		}

		try {
			session = this.getSession();
			session.update(user);
			session.flush();
		} catch (Exception e) {
			throw new RuntimeException(this.getClass().getName() + " --> " + e.getMessage());
		}

		return user;
	}
}