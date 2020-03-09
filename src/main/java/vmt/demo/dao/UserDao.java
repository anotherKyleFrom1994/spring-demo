package vmt.demo.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vmt.demo.model.entity.UserEntity;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public UserEntity findByUsername(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNativeQuery(
				"SELECT * FROM demo_users WHERE user_name = :user_name AND passwd = :passwd", UserEntity.class);
		query.setParameter("user_name", username);
		query.setParameter("passwd", password);
		List<?> resultList = query.getResultList();
		Iterator<?> iterator = resultList.iterator();
		UserEntity user = null;
		while (iterator.hasNext()) {
			user = (UserEntity) iterator.next();
		}
		return user;
	}
}