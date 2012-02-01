package dao;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.MetodoSpedizione;

public class MetodoSpedizioneHibernateDao extends HibernateDaoSupport implements MetodoSpedizioneDao {

	@Override
	public void update(MetodoSpedizione r) {
		getHibernateTemplate().update(r);
	}

	@Override
	public void delete(int id) {
		MetodoSpedizione indirizzo = (MetodoSpedizione) getHibernateTemplate().get(MetodoSpedizione.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	@Override
	public MetodoSpedizione findById(int id) {
		return (MetodoSpedizione) getHibernateTemplate().get(MetodoSpedizione.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MetodoSpedizione> findAll() {
		return getHibernateTemplate().find("from MetodoSpedizione");
	}

	@Override
	public int count() {
		return findAll().size();
	}

	@Override
	public void insert(MetodoSpedizione m) {
		getHibernateTemplate().saveOrUpdate(m);
	}
}
