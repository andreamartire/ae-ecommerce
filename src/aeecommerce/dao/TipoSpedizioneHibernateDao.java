package aeecommerce.dao;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.TipoSpedizione;


public class TipoSpedizioneHibernateDao extends HibernateDaoSupport implements TipoSpedizioneDao {

	public void update(TipoSpedizione r) {
		getHibernateTemplate().update(r);
	}

	public void delete(int id) {
		TipoSpedizione indirizzo = (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	public TipoSpedizione findById(int id) {
		return (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<TipoSpedizione> findAll() {
		return getHibernateTemplate().find("from TipoSpedizione");
	}

	public int count() {
		return findAll().size();
	}

	public void insert(TipoSpedizione m) {
		getHibernateTemplate().saveOrUpdate(m);
	}

	public void delete(TipoSpedizione entity) {
		getHibernateTemplate().delete(entity);
	}
}
