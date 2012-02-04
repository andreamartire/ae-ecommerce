package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Prodotto;

public class ProdottoHibernateDao extends HibernateDaoSupport implements ProdottoDao {
	public void insert(Prodotto entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Prodotto entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(Prodotto entity) {
		getHibernateTemplate().delete(entity);
	}

	public void delete(int id) {
		Prodotto entity = (Prodotto) getHibernateTemplate().get(Prodotto.class, id);
		getHibernateTemplate().delete(entity);
	}

	public Prodotto findByID(int id) {
		return (Prodotto) getHibernateTemplate().get(Prodotto.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Prodotto> findAll() {
		return getHibernateTemplate().find("from Prodotto");
	}

	public int count() {
		return findAll().size();
	}
}
