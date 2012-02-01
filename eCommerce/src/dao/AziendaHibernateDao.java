package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pojo.Azienda;

public class AziendaHibernateDao extends HibernateDaoSupport implements AziendaDao {

	@Transactional
	@Override
	public void insert(Azienda a) {
		getHibernateTemplate().save(a);
	}

	@Transactional
	@Override
	public void update(Azienda a) {
		getHibernateTemplate().update(a);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Azienda a = (Azienda) getHibernateTemplate().get(Azienda.class, id);
		getHibernateTemplate().delete(a);
	}

	@Transactional
	@Override
	public Azienda findByID(int id) {
		return (Azienda) getHibernateTemplate().get(Azienda.class,id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Azienda> findAllUsers() {
		return getHibernateTemplate().find("from Azienda");
	}

	@Transactional
	@Override
	public int userCount() {
		return findAllUsers().size();
	}
}