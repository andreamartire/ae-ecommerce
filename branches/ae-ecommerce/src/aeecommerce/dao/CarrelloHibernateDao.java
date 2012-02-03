package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Carrello;


public class CarrelloHibernateDao extends HibernateDaoSupport implements CarrelloDao {

	@Override
	public void insert(Carrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void update(Carrello entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(Carrello u) {
		getHibernateTemplate().delete(u);
	}

	@Override
	public void delete(int id) {
		Carrello carrello = (Carrello) getHibernateTemplate().get(Carrello.class, id);
		getHibernateTemplate().delete(carrello);
	}

	@Override
	public Carrello findByID(int id) {
		return (Carrello) getHibernateTemplate().get(Carrello.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrello> findAll() {
		return getHibernateTemplate().find("from Carrello");
	}

	@Override
	public int count() {
		return findAll().size();
	}

}
