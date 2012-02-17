package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.ElementoCarrello;

@Component
public class ElementoCarrelloHibernateDao extends MasterDao implements ElementoCarrelloDao {
	
	@Transactional
	@Override
	public void insert(ElementoCarrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void update(ElementoCarrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void delete(ElementoCarrello u) {
		getHibernateTemplate().delete(u);
	}

	@Transactional
	@Override
	public void delete(int id) {
		ElementoCarrello carrello = (ElementoCarrello) getHibernateTemplate().get(ElementoCarrello.class, id);
		getHibernateTemplate().delete(carrello);
	}

	@Transactional
	@Override
	public ElementoCarrello findByID(int id) {
		return (ElementoCarrello) getHibernateTemplate().get(ElementoCarrello.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<ElementoCarrello> findAll() {
		return getHibernateTemplate().find("from ElementoCarrello");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}
}
