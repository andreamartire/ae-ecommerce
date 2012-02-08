package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;

@Component
public class PrivatoHibernateDao extends HibernateDaoSupport implements PrivatoDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}

	@Transactional
	public void insert(Privato p) {
		getHibernateTemplate().save(p);
	}

	@Transactional
	public void update(Privato p) {
		getHibernateTemplate().update(p);
	}

	@Transactional
	public void delete(int id) {
		Privato a = (Privato) getHibernateTemplate().get(Privato.class, id);
		getHibernateTemplate().delete(a);
	}

	@Transactional
	public Privato findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> userList = getHibernateTemplate().findByExample(new Privato(username,null,null));
		if(userList != null && !userList.isEmpty())
			return (Privato) userList.get(0);
		return null;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Privato> findAll() {
		return getHibernateTemplate().find("from Privato");
	}

	@Transactional
	public int count() {
		return findAll().size();
	}

	@Override
	public Privato findById(int id) {
		return getHibernateTemplate().get(Privato.class, id);
	}
}