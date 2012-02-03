package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Ordine;


public class OrdineHibernateDao extends HibernateDaoSupport implements OrdineDao {

	@Override
	public void insert(Ordine p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Override
	public void update(Ordine p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Override
	public void delete(int id) {
		Ordine o = getHibernateTemplate().get(Ordine.class, id);
		getHibernateTemplate().delete(o);
	}

	@Override
	public Ordine findByID(int id) {
		return getHibernateTemplate().get(Ordine.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> findAll() {
		return getHibernateTemplate().find("from Ordine");
	}

	@Override
	public int count() {
		return findAll().size();
	}

	@Override
	public void delete(Ordine o) {
		getHibernateTemplate().delete(o);
	}

}
