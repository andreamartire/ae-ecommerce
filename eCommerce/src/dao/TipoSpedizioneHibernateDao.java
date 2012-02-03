package dao;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.TipoSpedizione;

public class TipoSpedizioneHibernateDao extends HibernateDaoSupport implements TipoSpedizioneDao {

	@Override
	public void update(TipoSpedizione r) {
		getHibernateTemplate().update(r);
	}

	@Override
	public void delete(int id) {
		TipoSpedizione indirizzo = (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	@Override
	public TipoSpedizione findById(int id) {
		return (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoSpedizione> findAll() {
		return getHibernateTemplate().find("from TipoSpedizione");
	}

	@Override
	public int count() {
		return findAll().size();
	}

	@Override
	public void insert(TipoSpedizione m) {
		getHibernateTemplate().saveOrUpdate(m);
	}

	@Override
	public void delete(TipoSpedizione entity) {
		getHibernateTemplate().delete(entity);
	}
}
