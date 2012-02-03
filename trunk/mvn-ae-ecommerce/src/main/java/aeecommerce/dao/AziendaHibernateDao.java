package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Azienda;



public class AziendaHibernateDao extends HibernateDaoSupport implements AziendaDao {

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
	public Azienda findByID(int id) {
		return (Azienda) getHibernateTemplate().get(Azienda.class,id);
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
}