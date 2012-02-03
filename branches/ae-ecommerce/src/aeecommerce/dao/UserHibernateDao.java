package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.User;


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
	
	@Override
	public User findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> userList = getHibernateTemplate().findByExample(new User(username,null,null));
		if(userList != null && !userList.isEmpty())
			return (User) userList.get(0);
		return null;
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
