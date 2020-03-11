package vmt.demo.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vmt.demo.conf.db.SessionFactoryInitializer.SessionFactoryCreator;
import vmt.demo.dao.IUserDao;
import vmt.demo.model.entity.UserEntity;

@Repository
public class UserDao extends SessionFactoryCreator implements IUserDao {

	private Session session = null;

	public UserDao() {
		super();
	}

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
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new RuntimeException(this.getClass().getName() + " --> " + e.getMessage());

		} finally {
			if (session != null) {
				session.flush();
			}
		}

		return user;
	}

	@Transactional(readOnly = true)
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
			if (session != null) {
				session.getTransaction().rollback();
			}

			throw new RuntimeException(this.getClass().getName() + " --> " + e.getMessage());
		}

		return user;
	}
}