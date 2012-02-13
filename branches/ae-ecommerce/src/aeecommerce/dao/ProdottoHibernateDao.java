package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Prodotto;

@Component
public class ProdottoHibernateDao extends MasterDao implements ProdottoDao {
	
	@Transactional
	@Override
	public void insert(Prodotto entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void update(Prodotto entity) {
		getHibernateTemplate().save(entity);
	}

	@Transactional
	@Override
	public void delete(Prodotto entity) {
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Prodotto entity = (Prodotto) getHibernateTemplate().get(Prodotto.class, id);
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	@Override
	public Prodotto findByID(int id) {
		return (Prodotto) getHibernateTemplate().get(Prodotto.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Prodotto> findAll() {
		return getHibernateTemplate().find("from Prodotto");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}
}
