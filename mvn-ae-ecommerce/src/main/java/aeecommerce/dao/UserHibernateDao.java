package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.User;


public class UserHibernateDao extends HibernateDaoSupport implements UserDao {

	public void insert(User u) {
		getHibernateTemplate().save(u);
	}

	public void update(User u) {
		getHibernateTemplate().update(u);
	}

	public void delete(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		getHibernateTemplate().delete(user);
	}

	public User findByID(int id) {
		return (User) getHibernateTemplate().get(User.class,id);
	}
	
	public User findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> userList = getHibernateTemplate().findByExample(new User(username,null,null));
		if(userList != null && !userList.isEmpty())
			return (User) userList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return getHibernateTemplate().find("from User");
	}

	public int count() {
		return findAll().size();
	}

	public void delete(User u) {
		getHibernateTemplate().delete(u);
	}
}
