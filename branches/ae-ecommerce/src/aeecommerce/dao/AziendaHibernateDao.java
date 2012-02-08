package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.User;

@Component
public class AziendaHibernateDao extends HibernateDaoSupport implements AziendaDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public void insert(Azienda a) {
		getHibernateTemplate().save(a);
	}

	@Transactional
	public void update(Azienda a) {
		getHibernateTemplate().update(a);
	}

	@Transactional
	public void delete(int id) {
		Azienda a = (Azienda) getHibernateTemplate().get(Azienda.class, id);
		getHibernateTemplate().delete(a);
	}

	@Transactional
	public Azienda findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> userList = getHibernateTemplate().findByExample(new Azienda(username,null,null));
		if(userList != null && !userList.isEmpty())
			return (Azienda) userList.get(0);
		return null;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Azienda> findAll() {
		return getHibernateTemplate().find("from Azienda");
	}

	@Transactional
	public int count() {
		return findAll().size();
	}

	public void delete(Azienda a) {
		getHibernateTemplate().delete(a);
	}

	@Override
	public Azienda findById(int id) {
		return getHibernateTemplate().get(Azienda.class, id);
	}
}