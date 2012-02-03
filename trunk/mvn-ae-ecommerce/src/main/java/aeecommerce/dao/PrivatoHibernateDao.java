package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;


public class PrivatoHibernateDao extends HibernateDaoSupport implements PrivatoDao {

	@Transactional
	public void insert(Privato p) {
		getHibernateTemplate().save(p);
	}

	@Transactional
	public void update(Privato p) {
		getHibernateTemplate().update(p);
	}

	@Transactional
	public void delete(int id) {
		Azienda a = (Azienda) getHibernateTemplate().get(Azienda.class, id);
		getHibernateTemplate().delete(a);
	}

	@Transactional
	public Privato findByID(int id) {
		return (Privato) getHibernateTemplate().get(Privato.class,id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Privato> findAll() {
		return getHibernateTemplate().find("from Privato");
	}

	@Transactional
	public int count() {
		return findAll().size();
	}
}