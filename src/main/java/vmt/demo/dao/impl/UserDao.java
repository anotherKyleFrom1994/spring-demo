package vmt.demo.dao.impl;

import javax.transaction.Synchronization;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vmt.demo.conf.db.SessionFactoryInitializer.SessionFactoryCreator;
import vmt.demo.dao.IUserDao;
import vmt.demo.model.entity.UserEntity;

@Repository
public class UserDao extends SessionFactoryCreator implements IUserDao {

	public UserDao() {
		super();
	}

	@Transactional(readOnly = true)
	@Override
	public UserEntity addUser(String username, String password) {
		Session session = null;
		UserEntity user = null;

		try {
			session = this.getSessionFactory().getCurrentSession();

			user = new UserEntity();
			user.setUserName(username);
			user.setPassword(password);

			session.persist(user);
			session.flush();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new RuntimeException(e.getMessage());
		}

		return user;
	}

	@Transactional(readOnly = true)
	@Override
	public UserEntity updateUser(UserEntity user) {
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.update(user);
			session.flush();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return user;
	}
}