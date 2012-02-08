package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.Prodotto;

@Component
public class ProdottoHibernateDao extends MasterDao implements ProdottoDao {
	
	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
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
