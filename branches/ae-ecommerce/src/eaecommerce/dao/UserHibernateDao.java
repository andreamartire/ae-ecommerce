package eaecommerce.dao;

import java.util.List;

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
	public User findByID(int id) {
		return (User) getHibernateTemplate().get(User.class,id);
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