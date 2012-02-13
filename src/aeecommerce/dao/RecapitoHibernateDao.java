package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Recapito;

@Component
public class RecapitoHibernateDao extends MasterDao implements RecapitoDao {
	
	@Transactional
	@Override
	public void update(Recapito r) {
		getHibernateTemplate().update(r);
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		Recapito recapito = (Recapito) getHibernateTemplate().get(Recapito.class, id);
		getHibernateTemplate().delete(recapito);
	}

	@Transactional
	@Override
	public Recapito findById(int id) {
		return (Recapito) getHibernateTemplate().get(Recapito.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Recapito> findAll() {
		return getHibernateTemplate().find("from Recapito");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

	@Transactional
	@Override
	public void delete(Recapito r) {
		getHibernateTemplate().delete(r);
	}

	@Transactional
	@Override
	public void insert(Recapito i) {
		getHibernateTemplate().save(i);
	}
}
