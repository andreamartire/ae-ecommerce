package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pojo.Azienda;
import pojo.Privato;

public class PrivatoHibernateDao extends HibernateDaoSupport implements PrivatoDao {

	@Transactional
	@Override
	public void insert(Privato p) {
		getHibernateTemplate().save(p);
	}

	@Transactional
	@Override
	public void update(Privato p) {
		getHibernateTemplate().update(p);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Azienda a = (Azienda) getHibernateTemplate().get(Azienda.class, id);
		getHibernateTemplate().delete(a);
	}

	@Transactional
	@Override
	public Privato findByID(int id) {
		return (Privato) getHibernateTemplate().get(Privato.class,id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Privato> findAllUsers() {
		return getHibernateTemplate().find("from Azienda");
	}

	@Transactional
	@Override
	public int userCount() {
		return findAllUsers().size();
	}
}