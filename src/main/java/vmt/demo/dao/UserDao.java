package vmt.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vmt.demo.model.entity.UserEntity;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public UserEntity addUser(String username, String password) {

		Session session = sessionFactory.getCurrentSession();
		UserEntity user = null;

//		Transaction tx = session.getTransaction();
//
//		if (!tx.isActive()) {
//			tx = session.beginTransaction();
//		}

		try {
			user = new UserEntity();
			user.setUserName(username);
			user.setPassword(password);
			
			session.persist(user);
			session.flush();

		} catch (Exception e) {
//			tx.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
//			session.close();
		}

		return user;
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(user);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return user;
	}
}