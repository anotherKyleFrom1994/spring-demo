//package vmt.demo.dao;
//
//import java.util.Iterator;
//
//import javax.persistence.Query;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import vmt.demo.model.User;
//
//public class UserDao implements IUserDao {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Transactional(readOnly = true)
//	public User findByUsername(String username, String password) {
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createNativeQuery(
//				"SELECT * FROM user WHERE user_name = :user_name AND password = :password ", User.class);
//		query.setParameter("user_name", username);
//		query.setParameter("password", password);
//		Iterator<?> iterator = query.getResultList().iterator();
//		User user = null;
//		while (iterator.hasNext()) {
//			user = (User) iterator.next();
//		}
//		return user;
//	}
//}