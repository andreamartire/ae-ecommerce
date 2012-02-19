package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Carrello;

@Component
public class CarrelloHibernateDao extends MasterDao implements CarrelloDao {

	@Transactional
	@Override
	public void insert(Carrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void update(Carrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void delete(Carrello u) {
		getHibernateTemplate().delete(u);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Carrello carrello = (Carrello) getHibernateTemplate().get(Carrello.class, id);
		getHibernateTemplate().delete(carrello);
	}

	@Transactional
	@Override
	public Carrello findByID(int id) {
		return (Carrello) getHibernateTemplate().get(Carrello.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Carrello> findAll() {
		return getHibernateTemplate().find("from Carrello");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

}
