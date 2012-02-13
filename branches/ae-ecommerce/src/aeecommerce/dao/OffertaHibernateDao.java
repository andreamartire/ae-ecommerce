package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Offerta;

@Component
public class OffertaHibernateDao extends MasterDao implements OffertaDao {
	
	@Transactional
	@Override
	public void insert(Offerta entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void update(Offerta entity) {
		getHibernateTemplate().save(entity);
	}

	@Transactional
	@Override
	public void delete(Offerta entity) {
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Offerta entity = (Offerta) getHibernateTemplate().get(Offerta.class, id);
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	@Override
	public Offerta findByID(int id) {
		return (Offerta) getHibernateTemplate().get(Offerta.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Offerta> findAll() {
		return getHibernateTemplate().find("from Offerta");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}
}
