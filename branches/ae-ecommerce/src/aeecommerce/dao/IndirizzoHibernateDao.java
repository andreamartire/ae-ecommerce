package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Indirizzo;


public class IndirizzoHibernateDao extends HibernateDaoSupport implements IndirizzoDao{

	@Override
	public void update(Indirizzo r) {
		getHibernateTemplate().update(r);
	}

	@Override
	public void delete(int id) {
		Indirizzo indirizzo = (Indirizzo) getHibernateTemplate().get(Indirizzo.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	@Override
	public Indirizzo findById(int id) {
		return (Indirizzo) getHibernateTemplate().get(Indirizzo.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Indirizzo> findAll() {
		return getHibernateTemplate().find("from Indirizzo");
	}

	@Override
	public int count() {
		return findAll().size();
	}

	@Override
	public void delete(Indirizzo r) {
		getHibernateTemplate().delete(r);
	}
}
