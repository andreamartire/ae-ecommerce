package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Carrello;


public class CarrelloHibernateDao extends HibernateDaoSupport implements CarrelloDao {

	public void insert(Carrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Carrello entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(Carrello u) {
		getHibernateTemplate().delete(u);
	}

	public void delete(int id) {
		Carrello carrello = (Carrello) getHibernateTemplate().get(Carrello.class, id);
		getHibernateTemplate().delete(carrello);
	}

	public Carrello findByID(int id) {
		return (Carrello) getHibernateTemplate().get(Carrello.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Carrello> findAll() {
		return getHibernateTemplate().find("from Carrello");
	}

	public int count() {
		return findAll().size();
	}

}
