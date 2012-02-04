package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.ElementoCarrello;

public class ElementoCarrelloHibernateDao extends HibernateDaoSupport implements ElementoCarrelloDao {

	public void insert(ElementoCarrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(ElementoCarrello entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(ElementoCarrello u) {
		getHibernateTemplate().delete(u);
	}

	public void delete(int id) {
		ElementoCarrello carrello = (ElementoCarrello) getHibernateTemplate().get(ElementoCarrello.class, id);
		getHibernateTemplate().delete(carrello);
	}

	public ElementoCarrello findByID(int id) {
		return (ElementoCarrello) getHibernateTemplate().get(ElementoCarrello.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<ElementoCarrello> findAll() {
		return getHibernateTemplate().find("from ElementoCarrello");
	}

	public int count() {
		return findAll().size();
	}
}
