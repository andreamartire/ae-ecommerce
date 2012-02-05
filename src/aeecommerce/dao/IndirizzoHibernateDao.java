package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.Indirizzo;

@Component
public class IndirizzoHibernateDao extends HibernateDaoSupport implements IndirizzoDao{

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public void update(Indirizzo r) {
		getHibernateTemplate().update(r);
	}

	public void delete(int id) {
		Indirizzo indirizzo = (Indirizzo) getHibernateTemplate().get(Indirizzo.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	public Indirizzo findById(int id) {
		return (Indirizzo) getHibernateTemplate().get(Indirizzo.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Indirizzo> findAll() {
		return getHibernateTemplate().find("from Indirizzo");
	}

	public int count() {
		return findAll().size();
	}

	public void delete(Indirizzo r) {
		getHibernateTemplate().delete(r);
	}
}
