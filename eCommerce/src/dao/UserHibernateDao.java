package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.User;

public class UserHibernateDao extends HibernateDaoSupport implements UserDao {

	@Override
	public void insert(User u) {
		getHibernateTemplate().save(u);
	}

	@Override
	public void update(User u) {
		getHibernateTemplate().update(u);
	}

	@Override
	public void delete(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		getHibernateTemplate().delete(user);
	}

	@Override
	public User findByID(int id) {
		return (User) getHibernateTemplate().get(User.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return getHibernateTemplate().find("from User");
	}

	@Override
	public int count() {
		return findAll().size();
	}

	@Override
	public void delete(User u) {
		getHibernateTemplate().delete(u);
	}
}
