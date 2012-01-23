package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import persistence.HibernateUtil;
import pojo.User;

public class UserHibernateDao implements UserDao {

	@Override
	public void insert(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(u);
		session.close();
	}

	@Override
	public void update(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(u);
		session.close();
	}

	@Override
	public void delete(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = (User) session.load(User.class, u.getId());
	    session.delete(user);
	    session.close();
	}

	@Override
	public User findByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (User) session.get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("from User").list();
	}

	@Override
	public int userCount() {
		return findAllUsers().size();
	}
}
