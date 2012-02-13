package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Indirizzo;

@Component
public class IndirizzoHibernateDao extends MasterDao implements IndirizzoDao{
	
	@Transactional
	@Override
	public void update(Indirizzo r) {
		getHibernateTemplate().update(r);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Indirizzo indirizzo = (Indirizzo) getHibernateTemplate().get(Indirizzo.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	@Transactional
	@Override
	public Indirizzo findById(int id) {
		return (Indirizzo) getHibernateTemplate().get(Indirizzo.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Indirizzo> findAll() {
		return getHibernateTemplate().find("from Indirizzo");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

	@Transactional
	@Override
	public void delete(Indirizzo r) {
		getHibernateTemplate().delete(r);
	}

	@Transactional
	@Override
	public void insert(Indirizzo i) {
		getHibernateTemplate().save(i);
	}
}
