package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.Recapito;

@Component
public class RecapitoHibernateDao extends HibernateDaoSupport implements RecapitoDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
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
