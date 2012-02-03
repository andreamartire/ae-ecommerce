package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Recapito;

public class RecapitoHibernateDao extends HibernateDaoSupport implements RecapitoDao {

	public void update(Recapito r) {
		getHibernateTemplate().update(r);
	}

	public void delete(int id) {
		Recapito recapito = (Recapito) getHibernateTemplate().get(Recapito.class, id);
		getHibernateTemplate().delete(recapito);
	}

	public Recapito findById(int id) {
		return (Recapito) getHibernateTemplate().get(Recapito.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Recapito> findAll() {
		return getHibernateTemplate().find("from Recapito");
	}

	public int count() {
		return findAll().size();
	}

	public void delete(Recapito r) {
		getHibernateTemplate().delete(r);
	}
}
