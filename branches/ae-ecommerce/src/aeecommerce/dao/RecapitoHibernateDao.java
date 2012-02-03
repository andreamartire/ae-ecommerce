package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Recapito;

public class RecapitoHibernateDao extends HibernateDaoSupport implements RecapitoDao {

	@Override
	public void update(Recapito r) {
		getHibernateTemplate().update(r);
	}

	@Override
	public void delete(int id) {
		Recapito recapito = (Recapito) getHibernateTemplate().get(Recapito.class, id);
		getHibernateTemplate().delete(recapito);
	}

	@Override
	public Recapito findById(int id) {
		return (Recapito) getHibernateTemplate().get(Recapito.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recapito> findAll() {
		return getHibernateTemplate().find("from Recapito");
	}

	@Override
	public int count() {
		return findAll().size();
	}

	@Override
	public void delete(Recapito r) {
		getHibernateTemplate().delete(r);
	}
}
