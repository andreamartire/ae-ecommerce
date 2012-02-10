package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import aeecommerce.pojo.Offerta;

@Component
public class OffertaHibernateDao extends MasterDao implements OffertaDao {
	
	public void insert(Offerta entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Offerta entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(Offerta entity) {
		getHibernateTemplate().delete(entity);
	}

	public void delete(int id) {
		Offerta entity = (Offerta) getHibernateTemplate().get(Offerta.class, id);
		getHibernateTemplate().delete(entity);
	}

	public Offerta findByID(int id) {
		return (Offerta) getHibernateTemplate().get(Offerta.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Offerta> findAll() {
		return getHibernateTemplate().find("from Offerta");
	}

	public int count() {
		return findAll().size();
	}
}