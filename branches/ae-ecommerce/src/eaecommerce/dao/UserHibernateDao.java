package eaecommerce.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import eaecommerce.pojo.Indirizzo;
import eaecommerce.pojo.User;


public class UserHibernateDao extends HibernateDaoSupport implements UserDao {

	@Transactional
	@Override
	public void insert(User u) {
		getHibernateTemplate().save(u);
	}

	@Transactional
	@Override
	public void update(User u) {
		getHibernateTemplate().update(u);
	}

	@Transactional
	@Override
	public void delete(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		getHibernateTemplate().delete(user);
	}

	@Transactional
	@Override
	public User findByUsername(String username) {
		List userList = getHibernateTemplate().findByExample(new User(username,null,null));
		if(userList != null && !userList.isEmpty())
			return (User) userList.get(0);
		return null;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		return getHibernateTemplate().find("from User");
	}

	@Transactional
	@Override
	public int userCount() {
		return findAllUsers().size();
	}
}
